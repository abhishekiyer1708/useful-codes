package general.problems;

public class FindNextBiggestNumber {
	//http://www.careercup.com/question?id=11543949
	//http://codepad.org/3yb97kQR

	public static void main(String[] args) {
		int input = 32768;
		int[] digitArray = new int[10];
		int i=0;
		while (input > 0) {
			digitArray[i++] = input%(10);
			input = input/(10);
		}
		for (int j=0; j<i;j++) {
			int temp = digitArray[i-1]; 
			digitArray[i-1] = digitArray[j];
			digitArray[j] = temp;
		}
		for (int j=0; j<i;j++) {
			System.out.println(digitArray[j]);
		}
		int nextTry = makeNextBigNumber(digitArray);
		if (nextTry>input) {
			//System.out.println(nextTry);
		}
	}
	
	public static int makeNextBigNumber(int[] array) {
		int j;
		int indexNum = array[array.length-1];
		for (j=array.length-2;j>0;j--) {
			if (array[j]<indexNum) {
				int temp = array[j];
				array[j] = array[array.length-1];
				array[array.length-1] = temp;
				break;
			}
		}
		for (j=0; j<array.length-1;j++) {
			System.out.println(array[j]);
		}
		return Integer.parseInt(String.valueOf(array));
	}

}
