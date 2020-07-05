package dynamicprogramming.similar.LCSubsequence;

public class NoOfDelandInsertion {

	public static void main(String[] args) {

		String s1 = "PACK";
		String s2 = "ACQ";
		
		NoOfDelandInsertion delandInsertion = new NoOfDelandInsertion();
		
		int lcs = delandInsertion.LCS(s1, s2, s1.length(), s2.length());
		
		System.out.println("No of deletion required="+delandInsertion.noOfDelorInsertion(s1, lcs));
		System.out.println("No of Insertion required="+delandInsertion.noOfDelorInsertion(s2, lcs));
		
	}
	
	
	private int noOfDelorInsertion(String a, int lcs) {
		return a.length() - lcs;
	}
	
	private int LCS(String a, String b, int m, int n) {
		
		Integer[][] t = new Integer[m+1][n+1];
		
		for (int i = 0; i < m+1; i++) {
			for (int j = 0; j <n+1; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;
				else if (a.charAt(i - 1) == b.charAt(j - 1))
					t[i][j] = 1 + t[i-1][j-1];
				else
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
			}
		}
		
		return t[m][n];
	}

}
