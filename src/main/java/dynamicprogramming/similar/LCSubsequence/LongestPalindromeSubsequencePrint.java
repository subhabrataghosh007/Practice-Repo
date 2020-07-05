package dynamicprogramming.similar.LCSubsequence;

public class LongestPalindromeSubsequencePrint {

	public static void main(String[] args) {

		LongestPalindromeSubsequencePrint subsequence = new LongestPalindromeSubsequencePrint();
		
		String a = "AGBCBA";
		
		String b = subsequence.reverse(a.toCharArray());
		
		Integer[][] t = subsequence.LCS(a, b, a.length(), b.length());
		
		subsequence.print(a, b, t);
		
	}
	
	private void print(String a, String b, Integer[][] t) {
		
		int m = a.length();
		int n = b.length();
		
		System.out.println("Lenght="+t[m][n]);
		
		int index = t[m][n];
		char[] s = new char[index];
		
		while (m >0 && n > 0) {
			if (a.charAt(m -1) == b.charAt(n-1)) {
				s[index-1] = a.charAt(m-1);
				m--;n--;index--;
			} else {
				if (t[m][n-1] > t[m-1][n]) {
					n--;
				} else
					m--;
			}
		}
		
		System.out.println(new String(s));
	}
	
	private Integer[][] LCS(String a,String b, int m, int n) {
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
	
	private String reverse(char[] ch) {
		int i = 0;
		int j = ch.length-1;
		
		while (i < j) {
			char temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
			i++;
			j--;
		}
		return new String(ch);
	}

}
