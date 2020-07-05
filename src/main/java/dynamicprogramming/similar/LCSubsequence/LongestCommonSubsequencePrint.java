package dynamicprogramming.similar.LCSubsequence;

public class LongestCommonSubsequencePrint {

	public static void main(String[] args) {

		String a = "ABCGFRTUSKIPGMSOSOIUULHGE";
		String b = "CGHBDDHE";

		
		LongestCommonSubsequencePrint print = new LongestCommonSubsequencePrint();
		Integer[][] t = print.LCS(a, b, a.length(), b.length());
		
		print.print_LCS(a, b, t);
		
	}
	
	
	private Integer[][] LCS(String a, String b, int m, int n) {
		
		Integer[][] t = new Integer[m+1][n+1];
		
		for (int i = 0; i < m+1; i++) {
			for (int j = 0; j < n+1; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;
				else if (a.charAt(i - 1) == b.charAt(j - 1))
					t[i][j] = 1 + t[i - 1][j - 1];
				else
					t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
			}
		}
		
		return t;
	}
	
	private void print_LCS(String a, String b, Integer[][] t) {
		
		int i = a.length(), j=b.length();
		StringBuilder s = new StringBuilder();
		
		while (i > 0 && j > 0) {
			if (a.charAt(i - 1) == b.charAt(j- 1)) {
				s.append(a.charAt(i - 1));
				i--;j--;
			} else
				if (t[i][j-1] > t[i-1][j])
					j--;
				else
					i--;
		}
		
		System.out.println(s.reverse());
	}

}
