package general.problems;

class Chat {
	
	public static void main(String[] args) {
		Chat m = new Chat();
        new T1(m);
        Chat m1 = new Chat();
        new T2(m);
	}
	
    boolean flag = false;

    public synchronized void Question(String msg) {
        if (flag) {
            try {
            	System.out.println("Thread 1 going to wait");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        flag = true;
        //notify();
    }

    public synchronized void Answer(String msg) {
        if (!flag) {
            try {
            	System.out.println("Thread 2 going to wait");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(msg);
        flag = false;
        notify();
    }
}

class T1 implements Runnable {
    Chat m;
    String[] s1 = { "Hi from Thread1", "How are you ?", "I am also doing fine!" };

    public T1(Chat m1) {
        this.m = m1;
        new Thread(this, "Question").start();
    }

    public void run() {
        for (int i = 0; i < s1.length; i++) {
            m.Question(s1[i]);
        }
    }
}

class T2 implements Runnable {
    Chat m;
    String[] s2 = { "Hi from Thread2", "I am good, what about you?", "Great!" };

    public T2(Chat m2) {
        this.m = m2;
        new Thread(this, "Answer").start();
    }

    public void run() {
        for (int i = 0; i < s2.length; i++) {
            m.Answer(s2[i]);
        }
    }
}

