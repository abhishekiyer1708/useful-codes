package general.problems;

public class FindNumberJustGreaterThanOtherNumber {

	/*
	 * Given two five digit numbers N1 and N2, find a five digit number formed
	 * by the digits of N2 (some permutation of N2) which is just greater than
	 * N1. Return -1 if there is no number possible.
	 * 
	 * Implement the following function:
	 * 
	 * int findNext(int N1, int N2);
	 * 
	 * Sample Input:
	 * 
	 * N1 = 53421, N2= 54322
	 * 
	 * Sample Output
	 * 
	 * 53422
	 */

	public static void main(String[] args) {

		System.out.println(findNext(53421, 54322));
	}

	static int findNext(int n1, int n2) {
		int[] digitArray = new int[5];
		int i = n2, j = 0, nextNumber = 0;
		boolean notPossible = true;
		while (i > 0) {
			digitArray[j++] = i % 10;
			i = i / 10;
		}
		for (int l = 0; l < digitArray.length; l++) {
			System.out.println(digitArray[l]);
		}
		System.out.println("--------");
		for (i = 0, j = i + 1; i < digitArray.length; i++) {
			if (digitArray[j] < digitArray[i]) {
				int temp = digitArray[j];
				digitArray[j] = digitArray[i];
				digitArray[i] = temp;
				nextNumber = makeNumber(digitArray);
				if (nextNumber > n1) {
					notPossible = false;
					break;
				}
			}
		}
		return notPossible ? -1 : nextNumber;
	}

	static int makeNumber(int[] digitArray) {
		for (int l = 0; l < digitArray.length; l++) {
			System.out.println(digitArray[l]);
		}
		System.out.println("----Call output ends----");
		int number = 0;
		for (int k = digitArray.length - 1; k >= 0; k--) {
			int powerOfTen = k;
			number += (digitArray[k] * (Math.pow(10, powerOfTen)));
			System.out.println("k = " + k + " " + number);
		}
		return number;
	}

}
