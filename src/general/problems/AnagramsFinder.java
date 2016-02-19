package general.problems;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class AnagramsFinder {
	
	public static void main(String args[]) {
		Map<String, List<String>> inputMap = new HashMap<String, List<String>>();
		
		try {
			Scanner s = new Scanner(new File(args[0]));
			while(s.hasNext()) {
				String word = s.next();
				String alphaword = sorting(word);
				List<String> values = inputMap.get(alphaword);
				
				if (values==null) {
					inputMap.put(alphaword, new ArrayList<String>());
					values.add(word);
				}
				
				List<String> l = inputMap.get(sorting(args[1]));
				Object[] arr = l.toArray();
				
				for (int i=0; i<arr.length; i++) {
					System.out.println(arr[i]);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private static String sorting(String word) {
		char[] a = word.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}

}
