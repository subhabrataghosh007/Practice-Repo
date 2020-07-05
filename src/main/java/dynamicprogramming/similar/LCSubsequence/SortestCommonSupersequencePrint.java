package dynamicprogramming.similar.LCSubsequence;

public class SortestCommonSupersequencePrint {

	public static void main(String[] args) {

		String a = "AGGTAB";
		String b = "GXTXAYB";
		
		SortestCommonSupersequencePrint print = new SortestCommonSupersequencePrint();
		
		Integer[][] t = print.LCS(a, b, a.length(), b.length());
		
		print.print(a, b, t);
	}
	
	private void print(String a, String b, Integer[][] t) {
		
		int i = a.length();
		int j = b.length();
		StringBuilder s = new StringBuilder();
		
		while (i > 0 && j > 0) {
			if (a.charAt(i - 1) == b.charAt(j - 1)) {
				s.append(a.charAt(i - 1));
				i--;j--;
			} else if (t[i][j-1] > t[i-1][j]) {
				s.append(b.charAt(j-1));
				j--;
			} else {
				s.append(a.charAt(i-1));
				i--;
			}
		}
		
		while (i > 0) {
			s.append(a.charAt(i-1));
			i--;
		}
		while (j > 0) {
			s.append(b.charAt(j - 1));
			j--;
		}
		
		System.out.println(s.reverse());
	}

	private Integer[][] LCS(String a, String b, int m, int n) {
		
		Integer[][] t = new Integer[m+1][n+1];
		
		for (int i = 0; i < m+1; i++) {
			for (int j = 0; j < n+1; j++) {
				
				if (i == 0 || j == 0)
					t[i][j] = 0;
				else if (a.charAt(i - 1) == b.charAt(j - 1))
					t[i][j] = 1 + t[i-1][j-1];
				else
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
			}
		}
		return t;
	}
}
