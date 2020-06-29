package dynamicprogramming.similar.knapsack;

public class SubsetSum {

	static Boolean[][] table;

	public static void main(String[] args) {

		SubsetSum subsetSum = new SubsetSum();

		int[] arr = { 10, 2, 8, 7, 3, 10, 100, 43, 76, 33, 36, 22, 87, 23, 11, 122, 33, 223, 555, 22, 222, 13, 45, 223,
				12};
		int sum = 2000;
		
		//int sum = 2000;

		boolean val;
		
		long endTime = 0;
		long startTime = 0;
		
		System.out.println("----------------------Recursive----------------------");
		startTime = System.currentTimeMillis();
		val = subsetSum.recursiveApproach(arr, sum, arr.length);
		endTime = System.currentTimeMillis();
		System.out.println("Recursive took " + (endTime - startTime) + " milliseconds");
		System.out.println(val);
		
		System.out.println("----------------------Memoization----------------------");
		table = new Boolean[arr.length + 1][sum + 1];
		startTime = System.currentTimeMillis();
		val = subsetSum.memoizationApproach(arr, sum, arr.length);
		endTime = System.currentTimeMillis();
		System.out.println("Recursive took " + (endTime - startTime) + " milliseconds");
		System.out.println(val);
		
		System.out.println("----------------------TopDown-----------------------");
		startTime = System.currentTimeMillis();
		val = subsetSum.topDownApproach(arr, sum, arr.length);
		endTime = System.currentTimeMillis();
		System.out.println("Recursive took " + (endTime - startTime) + " milliseconds");
		System.out.println(val);
		
	}

	private boolean recursiveApproach(int arr[], int sum, int n) {

		if (sum == 0)
			return true;
		
		if (n == 0 && sum != 0) {
			return false;
		}

		if (sum >= arr[n - 1]) {
			return recursiveApproach(arr, sum - arr[n - 1], n - 1) || recursiveApproach(arr, sum, n - 1);
		} else {
			return recursiveApproach(arr, sum, n - 1);
		}
	}
	
	private boolean memoizationApproach(int arr[], int sum, int n) {
		
		if (sum == 0)
			return true;
		
		if (n == 0 && sum != 0)
			return false;
		
		if (table[n][sum] != null)
			return table[n][sum];
		else {
			if (sum >= arr[n - 1])
				return table[n][sum] = memoizationApproach(arr, sum - arr[n - 1], n - 1) || memoizationApproach(arr, sum, n - 1);
			else
				return table[n][sum] = memoizationApproach(arr, sum, n - 1);
		}
	}

	private boolean topDownApproach(int arr[], int sum, int n) {
		boolean[][] table = new boolean[arr.length + 1][sum + 1];
		
		for (int i = 0; i < arr.length+1; i++) {
			for (int j = 0; j < sum+1; j++) {
				if (i == 0) {
					table[i][j] = false;
				}
				if (j == 0) {
					table[i][j] = true;
				}
				if ( i != 0 && j != 0) {
					break;
				}
			}
		}
		
		for (int i = 1; i < arr.length+1; i++) {
			for (int j = 1; j < sum+1; j++) {
				if (j >= arr[i -1])
					table[i][j] = table[i - 1][j - arr[i - 1]] || table[i - 1][j];
				else
					table[i][j] = table[i - 1][j];
			}
		}
		
		return table[n][sum];
	}
}
