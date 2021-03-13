package dynamicprogramming.similar.LCSubsequence;

public class LongestPalindromeSubstringPrint {

	public static void main(String[] args) {

		LongestPalindromeSubstringPrint subsequence = new LongestPalindromeSubstringPrint();
		
		//String a = "AGBCBA";
		String a = "aacdefcaa";
		
		String b = subsequence.reverse(a.toCharArray());
		
		int lcs = subsequence.LCS(a, b, a.length(), b.length());
		System.out.println("Longest Palindrome Subsequence="+lcs);
		
	}
	
	private int LCS(String a, String b, int m, int n) {
		Integer[][] t = new Integer[m+1][n+1];
		
		int max = -1;
		int row = 0, col = 0;
		
		for (int i = 0; i < m+1; i++) {
			for (int j = 0; j < n+1; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;
				else if (a.charAt(i - 1) == b.charAt(j - 1)) {
					t[i][j] = 1 + t[i-1][j-1];
					if (max < t[i][j]) {
						max = t[i][j];
						row = i;
						col = j;
					}
				}
				else
					t[i][j] = 0;
			}
		}
		
		StringBuilder sb = new StringBuilder();
        //while (t[row][col] != 0) {
        while (row >0 && col >0) {
        	
        	sb.append(a.charAt(row-1));
        	row--;
        	col--;
        }
        
        System.out.println(sb.reverse());
		return max;
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
