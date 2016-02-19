package general.problems;

public class ArrayDuplicatesRemoval {
	 
	
	public static void main(String args[]) {
		int[] inputArray = {2, 4, 5, 9, 3, 4, 2, 6};

		int newLength = 1;
		int i,j;
		for (i=1;i<inputArray.length;i++) {
			for (j=0;j<newLength;j++) {
				if (inputArray[i]==inputArray[j])
					break;
			}
			if (j==newLength) {
				inputArray[newLength++] = inputArray[i];
			}
		}
		
		for (i=0;i<newLength;i++)
			System.out.println(inputArray[i]);
	}

}
