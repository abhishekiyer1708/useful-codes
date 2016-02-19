package general.problems;

public class MaxProductInArrayInAscendingOrder {

	public static void main(String[] args) {
		int[] inputArray = {1, 2, 7, 4, 9, 1, 3, 8, 1 };
		
		int[] testArray1 = {12, 11, 1, 7, 9, 8};
		
		int[] answer = findSubsequenceWithMaxProductInAscendingOrder(testArray1);
		for (int i=0;i<3;i++) {
			System.out.println(answer[i]);
		}
		
		answer = findSubsequenceWithMaxProduct(inputArray);
		for (int i=0;i<3;i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static int[] findSubsequenceWithMaxProductInAscendingOrder(int[] inputArray) {
        int maxProduct = 0;
        int[] subsequenceWithLargestProduct = new int[3];
        for (int i = 1; i < inputArray.length - 1; i++) {
            int leftLowest = 0;
            int rightHighest = 0;
            // find lowest on the left.
            for (int j = 0; j < i; j++) {
                if (inputArray[j] < inputArray[i] && inputArray[j] > leftLowest) {
                    leftLowest = inputArray[j];
                }
            }
            // find highest on right.
            for (int k = i + 1; k < inputArray.length; k++) {
                if (inputArray[k] > inputArray[i] && inputArray[k] > rightHighest) {
                    rightHighest = inputArray[k];
                }
            }
            int currentProduct = inputArray[i] * leftLowest * rightHighest;
            if (currentProduct > maxProduct) {
                maxProduct = currentProduct;
                subsequenceWithLargestProduct = new int[]{leftLowest, inputArray[i], rightHighest};
            }
        }
        return subsequenceWithLargestProduct;
    }
	
	public static int[] findSubsequenceWithMaxProduct(int[] inputArray) {
        int maxProduct = 0;
        int[] subsequenceWithLargestProduct = new int[3];
        for (int i = 1; i < inputArray.length - 1; i++) {
            int leftLowest = 0;
            int rightHighest = 0;
            // find lowest on the left.
            for (int j = 0; j < i; j++) {
                if (inputArray[j] > leftLowest) {
                    leftLowest = inputArray[j];
                }
            }
            // find highest on right.
            for (int k = i + 1; k < inputArray.length; k++) {
                if (inputArray[k] > rightHighest) {
                    rightHighest = inputArray[k];
                }
            }
            int currentProduct = inputArray[i] * leftLowest * rightHighest;
            if (currentProduct > maxProduct) {
                maxProduct = currentProduct;
                subsequenceWithLargestProduct = new int[]{leftLowest, inputArray[i], rightHighest};
            }
        }
        return subsequenceWithLargestProduct;
    }
	
	public static int[] findSubsequenceWithMaxProductInAscendingOrderBestSol(int[] inputArray) {
        int maxProduct = 0;
        int[] less = new int[inputArray.length];
        int[] more = new int[inputArray.length];
        
        for (int j = 0; j < i; j++) {
            if (inputArray[j] < inputArray[i] && inputArray[j] > leftLowest) {
                less[i] = inputArray[j];
            }
        }
        int[] subsequenceWithLargestProduct = new int[3];
        for (int i = 1; i < inputArray.length - 1; i++) {
            int leftLowest = 0;
            int rightHighest = 0;
            // find lowest on the left.
            for (int j = 0; j < i; j++) {
                if (inputArray[j] < inputArray[i] && inputArray[j] > leftLowest) {
                    leftLowest = inputArray[j];
                }
            }
            // find highest on right.
            for (int k = i + 1; k < inputArray.length; k++) {
                if (inputArray[k] > inputArray[i] && inputArray[k] > rightHighest) {
                    rightHighest = inputArray[k];
                }
            }
            int currentProduct = inputArray[i] * leftLowest * rightHighest;
            if (currentProduct > maxProduct) {
                maxProduct = currentProduct;
                subsequenceWithLargestProduct = new int[]{leftLowest, inputArray[i], rightHighest};
            }
        }
        return subsequenceWithLargestProduct;
    }

}
