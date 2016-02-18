package algos;

/**
 * 
 * This class is used to find the longest common substring between two input
 * strings
 * 
 * @author RAVI
 *
 */
public class LongestCommonSubString {

	public static String findCommonSubString(String s1, String s2) {
		String output = null;
		int[][] arr = new int[s1.length()][s2.length()];
		int max = 0;
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					if (i == 0 || j == 0)
						arr[i][j] = 1;
					else
						arr[i][j] = arr[i - 1][j - 1] + 1;
					if (arr[i][j] >= max) {
						max = arr[i][j];
						output = s1.substring(i - max + 1, i + 1);
					}
				}
			}
		}
		return output;
	}
	
	 /** Test the api */ 
	  public static void main(String[] s) {
	   System.out.println(findCommonSubString("abcd","bcab")); }
	 
}
