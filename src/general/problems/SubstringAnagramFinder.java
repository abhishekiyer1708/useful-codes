package general.problems;

import java.util.Arrays;

public class SubstringAnagramFinder {

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		System.out.println(checkAnagram("fart", "frat"));
		long t2 = System.currentTimeMillis();
		System.out.println(betterAnagramChecker("fart", "frat"));
		long t3 = System.currentTimeMillis();
		System.out.println("Test 1 time : " + (t2-t1));
		System.out.println("Test 2 time : " + (t3-t2));
	}
	
	public static String checkAnagram(String first, String second){
        char[] characters = first.toCharArray();
        StringBuilder sbSecond = new StringBuilder(second);
        int counter = 0;
        int lastIndex = 0;
        char[] output = new char[second.toCharArray().length];
        for(char ch : characters){
            int index = sbSecond.indexOf("" + ch);
            //System.out.println(ch + " " + index);
            if(index != -1 && (Math.abs(lastIndex-index) <= characters.length)){
                counter++;
                lastIndex = index;
                output[index] = ch;
            }
        }
        //System.out.println(counter);
       if (counter == characters.length) {
    	   StringBuffer sb = new StringBuffer();
    	   for (int i=0;i<output.length;i++) {
    			   sb.append(output[i]);
    	   }
    	   return sb.toString();
       }
        return "NONE";
    }
	
	public static String betterAnagramChecker(String first, String second) {
		int baseStringLength = first.length();
		//char[] charArray = second.toCharArray();
		for (int i=0; i<baseStringLength;i++) {
			String subString = second.substring(i, i+baseStringLength);
			if (basicAnagramCheck(first, subString)) {
				return subString;
			}
		}
		return "NONE";
	}

	private static boolean basicAnagramCheck(String first, String subString) {
		char[] firstArray = first.toCharArray();
		char[] secondArray = subString.toCharArray();
		boolean result = true;
		Arrays.sort(firstArray);
		Arrays.sort(secondArray);
		for (int j=0; j<firstArray.length;j++) {
			if (firstArray[j]!=secondArray[j]) {
				result = false;
			}
		}
		return result;
	}

}
