package dynamicprogramming.similar.LCSubsequence;

public class LongestRepeatingSubsequence {

	public static void main(String[] args) {

		String a = "ABACBDPPD";
		//String a = "DPPPPD";
		
		LongestRepeatingSubsequence repeatingSubsequence = new LongestRepeatingSubsequence();
		
		int lcs = repeatingSubsequence.LCS(a);
		
		System.out.println("Longest Repeating Subsequence="+lcs);
		
	}
	
	private int LCS(String a) {
		int m=a.length(), n = a.length();
		Integer[][] t = new Integer[m+1][n+1];
		
		for (int i = 0; i < m+1; i++) {
			for (int j = 0; j < n+1; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;
				else if (a.charAt(i-1) == a.charAt(j-1) && i != j)
					t[i][j] = 1+ t[i-1][j-1];
				else
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
			}
		}
		
		return t[m][n];
		
	}

}
