package dynamicprogramming.similar.LCSubsequence;

public class aaa {

	public static void main(String[] args) {

		int[] arr = {1, 6, 9};
		
		System.out.println(unboundedKnapsack(12, arr));
		
	}

	static int unboundedKnapsack(int k, int[] arr) {
		int n = arr.length;
		System.out.println(n);
		Integer[][] t = new Integer[n + 1][k + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < k + 1; j++) {
				if (i == 0)
					t[i][j] = 0;
				else if (j == 0)
					t[i][j] = 0;
				else if (j >= arr[i - 1]) {
					t[i][j] = Math.max(arr[i - 1] + t[i][j - arr[i - 1]], t[i - 1][j]);
				}
				else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[n][k];
	}
}
