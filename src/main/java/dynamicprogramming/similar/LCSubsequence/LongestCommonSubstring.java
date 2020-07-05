package dynamicprogramming.similar.LCSubsequence;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubstring {

	public static void main(String[] args) {

		
		String a = "Subhabrata";
		String b = "Subha";
		
		
		long endTime = 0;
		long startTime = 0;
		int val = 0;
		
		LongestCommonSubstring substring = new LongestCommonSubstring();
		
		System.out.println("----------------------Recursive-------------");
		startTime = System.currentTimeMillis();
		val = substring.recursion_LCSubstring(a, b, a.length(), b.length(), Integer.MIN_VALUE);
		endTime = System.currentTimeMillis();
		System.out.println("Recursive took " + (endTime - startTime) + " milliseconds");
		System.out.println(val);
		
		
		System.out.println("----------------------Memoization------------------");
		startTime = System.currentTimeMillis();
		val = substring.memoization_LCSubstring(a, b, a.length(), b.length(), 0);
		endTime = System.currentTimeMillis();
		System.out.println("Memoization took " + (endTime - startTime) + " milliseconds");
		System.out.println(val);
		
		System.out.println("----------------------TopDown-----------------------");
		startTime = System.currentTimeMillis();
		val = substring.topdown_LCSubstring(a, b, a.length(), b.length());
		endTime = System.currentTimeMillis();
		System.out.println("TopDown took " + (endTime - startTime) + " milliseconds");
		System.out.println(val);
	}
	
	private int recursion_LCSubstring(String a, String b, int m, int n, int count) {
		
		if (m == 0 || n == 0)
			return count;
		
		if (a.charAt(m - 1) == b.charAt(n - 1))
			count = recursion_LCSubstring(a, b, m - 1, n - 1, count+1);
		
		count = Math.max(count, Math.max(recursion_LCSubstring(a, b, m, n-1, 0), recursion_LCSubstring(a, b, m-1, n, 0)));
		
		return count;
	}
	
	static Map<String, Integer> map = new HashMap<>();
	private int memoization_LCSubstring(String a, String b, int m, int n, int count) {
		
		if (m == 0 || n == 0)
			return count;
		
		String key = m+"-"+n+"-"+count;
		
		if (map.get(key) != null)
			return map.get(key);
		
		if (a.charAt(m - 1) == b.charAt(n - 1)) {
			count = memoization_LCSubstring(a, b, m - 1, n - 1, count+1);
			map.put(key, count);
		}
		else {
			count = Math.max(count, Math.max(memoization_LCSubstring(a, b, m, n-1, 0), memoization_LCSubstring(a, b, m-1, n, 0)));
			map.put(key, count);
		}
		
		return map.get(key);
	}

	private int topdown_LCSubstring(String a, String b, int m, int n) {
		
		Integer[][] table = new Integer[m+1][n+1];
		
		for (int i = 0; i < m+1; i++) {
			for (int j = 0; j < n+1; j++) {
				if (i ==0 || j == 0)
					table[i][j] = 0;
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 1; i < m+1; i++) {
			for (int j = 1; j < n+1; j++) {
				
				if (a.charAt(i - 1) == b.charAt(j - 1))
					table[i][j] = 1 + table[i - 1][j - 1];
				else
					table[i][j] = 0;
				
				if (max < table[i][j])
					max = table[i][j];
			}
		}
		
		return max;
	}
}
