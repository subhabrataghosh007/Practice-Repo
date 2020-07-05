package dynamicprogramming.similar.LCSubsequence;

public class LongestCommonSubsequence {

	static Integer[][] t;

	public static void main(String[] args) {

//		String a = "ABCGFRTUSKIPGMSOSOIUULHGE";
//		String b = "CGKGSONFLDOELHBDDHE";

		String a = "ABCGFRTUSKIPGMSOSOIUULHGE";
		String b = "CGHBDDHE";

		long endTime = 0;
		long startTime = 0;
		int val = 0;

		LongestCommonSubsequence subsequesce = new LongestCommonSubsequence();

		System.out.println("----------------------Recursive-------------");
		startTime = System.currentTimeMillis();
		val = subsequesce.recursion_LCS(a, b, a.length(), b.length());
		endTime = System.currentTimeMillis();
		System.out.println("Recursive took " + (endTime - startTime) + " milliseconds");
		System.out.println(val);

		System.out.println("----------------------Memoization------------------");
		t = new Integer[a.length() + 1][b.length() + 1];
		startTime = System.currentTimeMillis();
		val = subsequesce.memoization_LCS(a, b, a.length(), b.length());
		endTime = System.currentTimeMillis();
		System.out.println("Memoization took " + (endTime - startTime) + " milliseconds");
		System.out.println(val);

		System.out.println("----------------------TopDown-----------------------");
		startTime = System.currentTimeMillis();
		val = subsequesce.topdown_LongestCommonSubsequesce(a, b, a.length(), b.length());
		endTime = System.currentTimeMillis();
		System.out.println("TopDown took " + (endTime - startTime) + " milliseconds");
		System.out.println(val);

	}

	private int recursion_LCS(String a, String b, int m, int n) {

		if (m == 0 || n == 0)
			return 0;

		if (a.charAt(m - 1) == b.charAt(n - 1))
			return 1 + recursion_LCS(a, b, m - 1, n - 1);
		else
			return Integer.max(recursion_LCS(a, b, m, n - 1), recursion_LCS(a, b, m - 1, n));
	}

	private int memoization_LCS(String a, String b, int m, int n) {

		if (m == 0 || n == 0)
			return 0;

		if (t[m][n] != null)
			return t[m][n];

		if (a.charAt(m - 1) == b.charAt(n - 1))
			return t[m][n] = 1 + memoization_LCS(a, b, m - 1, n - 1);
		else
			return t[m][n] = Integer.max(memoization_LCS(a, b, m, n - 1), memoization_LCS(a, b, m - 1, n));
	}

	private int topdown_LongestCommonSubsequesce(String a, String b, int m, int n) {

		Integer[][] table = new Integer[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0)
					table[i][j] = 0;
				if (i != 0 && j != 0)
					break;
			}
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {

				if (a.charAt(i - 1) == b.charAt(j - 1))
					table[i][j] = 1 + table[i - 1][j - 1];
				else
					table[i][j] = Integer.max(table[i][j - 1], table[i - 1][j]);

			}
		}

		return table[m][n];
	}
}
