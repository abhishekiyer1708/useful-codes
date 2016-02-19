package practice.stringQuestions;

public class ReverseOrderOfWordsInString {

	public static void main(String[] args) {
		String s = "My name is Abhishek Iyer";
		char[] str = s.toCharArray();
		int i = 0;
		rev(str, i, s.length());
		int j = 0;
		while (j < str.length) {
			if (str[j] != ' ' && j != str.length - 1) {
				j++;
			} else {
				if (j == (str.length - 1)) {
					j++;
				}
				rev(str, i, j);
				i = j + 1;
				j = i;
			}
		}
		System.out.println(str);
	}

	public static char[] rev(char[] a, int left, int right) {
		char temp;
		for (int i = 0; i < (right - left) / 2; i++) {
			temp = a[i + left];
			a[i + left] = a[right - i - 1];
			a[right - i - 1] = temp;
		}

		return a;
	}

}
