package general.problems;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockTest {

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		final ReentrantLock  lock1 = new ReentrantLock ();
		final ReentrantLock  lock2 = new ReentrantLock ();

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock1) {
					System.out.println("Thread1 acquired lock1");
					sleepTime(50);
					synchronized (lock2) {
						System.out.println("Thread1 acquired lock2");
					}
				}
				System.out.println("End of thread1");
			}

		});
		thread1.start();

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock2) {
					System.out.println("Thread2 acquired lock2");
					sleepTime(50);
					synchronized (lock1) {
						System.out.println("Thread2 acquired lock1");
					}
					System.out.println("End of thread2");
				}
			}
		});
		thread2.start();

		// Wait a little for threads to deadlock.
		sleepTime(100);

		detectDeadlock();
		System.out.println("End of Program");
	}

	private static void detectDeadlock() {
		ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
		long[] ids = threadBean.findMonitorDeadlockedThreads();
		int deadlockedThreads = ids != null ? ids.length : 0;
		System.out
				.println("Number of deadlocked threads: " + deadlockedThreads);

		if (ids != null) {
			ThreadInfo[] infos = threadBean.getThreadInfo(ids, true, true);
			System.out.println("the following threads are deadlocked:");
			for (ThreadInfo ti : infos) {
				System.out.println(ti);
				System.out.println("BlockedTime->"+ti.getBlockedTime());
				System.out.println("BlockedCount->"+ti.getBlockedCount());
				System.out.println("LockInfo->"+ti.getLockInfo());
			}
		}
	}
	private static void sleepTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException ignore) {
		}
	}
}
