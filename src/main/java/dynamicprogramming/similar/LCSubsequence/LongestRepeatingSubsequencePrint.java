package dynamicprogramming.similar.LCSubsequence;

public class LongestRepeatingSubsequencePrint {

	public static void main(String[] args) {

		String a = "ABACBDPPD";
		//String a = "DPPPPD";
		
		LongestRepeatingSubsequencePrint print = new LongestRepeatingSubsequencePrint();
		
		Integer[][] t_lcs = print.LCS(a);
		
		print.print(t_lcs, a);
		
	}
	
	private void print(Integer[][] t, String a) {
		
		int m = a.length();
		int n = m;
		
		StringBuilder s = new StringBuilder();
		
		while (m > 0 && n >0) {
			if (a.charAt(m-1) == a.charAt(n-1) && m != n) {
				s.append(a.charAt(m-1));
				m--;n--;
			} else {
				if (t[m][n-1] > t[m-1][n]) {
					n--;
				} else {
					m--;
				}
			}
		}
		
		System.out.println(s.reverse());
	}
	
	private Integer[][] LCS(String a) {
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
		
		return t;
	}

}
