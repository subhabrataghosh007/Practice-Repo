package dynamicprogramming.similar.LCSubsequence;

public class SortestCommonSupersequence {

	public static void main(String[] args) {

		String a = "AGGTAB";
		String b = "GXTXAYB";

		SortestCommonSupersequence supersequence = new SortestCommonSupersequence();
		
		int lenghtSCS = supersequence.lenghtSCS(a, b);
		
		System.out.println("Lenght of Sortest Common Supersequence = "+lenghtSCS);
		
	}
	
	private int lenghtSCS(String a, String b) {
		
		 int m = a.length(), n = b.length();
		 
		 int lcs = LCS(a, b, a.length(), b.length());
		 
		 return (m+n-lcs);
	}
	
	private int LCS(String a, String b, int m, int n) {
		
		Integer[][] t = new Integer[m+1][n+1];
		
		for (int i = 0; i < m+1;i++) {
			for (int j = 0; j  <n+1; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;
				else if (a.charAt(i - 1) == b.charAt(j - 1))
					t[i][j] = 1 + t[i - 1][j - 1];
				else
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
			}
		}
		return t[m][n];
	}

}
