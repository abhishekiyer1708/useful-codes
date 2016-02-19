package general.problems;

public class ArrayInversionCount {

	public static void main(String[] args) {
		int[] A = {2,4,1,3,5};
		System.out.println(countInversion(A));
	}
	
	static int countInversion(int[] A) {
		int i,j, inv_count = 0;
		for (i=0; i < A.length-1; i++) {
			for (j=i+1; j<A.length; j++) {
				if (A[i] > A[j])
					inv_count++;
			}
		}
		return inv_count;
	}
}
