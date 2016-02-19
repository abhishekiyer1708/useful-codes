package general.problems;


public class JmeterCodes {

	public static void main(String[] args) {
		String[] input = {"1", "2", "3", "4"};
		System.out.println(getIdsString(input, 0, 3));
	}
	
	static String getIdsString (String[] input, int start, int end) {
        StringBuilder output = new StringBuilder();
        for (int i=start; i<=end;i++) {
            output.append(input[i]);
            output.append(";");
        }
        return output.toString();
    }

}
