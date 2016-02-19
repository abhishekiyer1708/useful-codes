package general.problems;



public class MaxSequenceValueArray {

	public static void main(String[] args) {
		int[] inputArray = {1, 2, -3, -4, 5, -2, -4, 3, -9 };
		
		System.out.println(getMaxSeqValue(inputArray) + "\n");
		
		System.out.println(getMaxSeqValue(new int[] {-5,-4, -1}));
	}
	
	public static int getMaxSeqValue(int[] inputArray) {
		int length = inputArray.length;
		int i,max=0,sum=0;
		
		for (i=0;i<length;i++) {
			sum += inputArray[i];
			if (sum<0) {
				sum = 0;
			}else if (sum>max) {
				max = sum;
			}
		}
		return max;
	}
	
	public static int getMaxSeqValueModified(int[] inputArray) {
		int length = inputArray.length;
		int i,max=0,sum=0, negativeSum;
		
		for (i=0;i<length;i++) {
			sum += inputArray[i];
			if (sum<0) {
				negativeSum = sum;
			}else if (sum>max) {
				max = sum;
			}
		}
		return max;
	}

}
