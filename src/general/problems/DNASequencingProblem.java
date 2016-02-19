/**
 * 
 */
package general.problems;

/**
 * @author SG0215046
 *
 */
public class DNASequencingProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String dna1 = "";
		String dna2 = "";
		
		System.out.println(getDNAAlignment(dna1, dna2));

	}
	
	static int getDNAAlignment(String dna1, String dna2) {
		int[][] scoringArray = new int[][] {
				{5, -1, -2, -1, -3},
				{-1, 5, -3, -2, -4},
				{-2, -3, 5, -2, -2},
				{-1, -2, -2, 5, -1},
				{-3, -4, -2, -1, 0}
		};
		int lenDiff = 0;
		if (dna1.length() > dna2.length()) {
			lenDiff = dna1.length() - dna2.length();
			dna2 = makeEqualLength(dna2, lenDiff);
		} else {
			lenDiff = dna2.length() - dna1.length();
			dna1 = makeEqualLength(dna1, lenDiff);
		}
		char[] dna1Array = dna1.toCharArray();
		char[] dna2Array = dna2.toCharArray();
		for (int i=0;i<dna1.length();i++) {
			
		}
		
		return 0;

    }

	private static String makeEqualLength(String string, int lenDiff) {
		for (int i=0;i<lenDiff;i++) {
			string.concat("-");
		}
		return string;
	}


}
