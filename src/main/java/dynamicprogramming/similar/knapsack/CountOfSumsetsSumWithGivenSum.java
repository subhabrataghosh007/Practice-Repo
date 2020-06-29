package dynamicprogramming.similar.knapsack;

public class CountOfSumsetsSumWithGivenSum {

	public static void main(String[] args) {

		int[] arr = { 10, 2, 8, 7};
		int sum = 10;
		
		CountOfSumsetsSumWithGivenSum count = new CountOfSumsetsSumWithGivenSum();
		int c = count.topDown(arr, arr.length, sum);
		System.out.println(c);
	}
	
	private int topDown(int arr[], int n, int sum) {
		Integer[][] table = new Integer[n+1][sum+1];
		
		for (int i = 0; i < sum+1; i++)
			table[0][i] = 0;
		for (int i = 0; i < n+1; i++)
			table[i][0] = 1;
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < sum+1; j++) {
				
				if (j >= arr[i -1])
					table[i][j] = table[i - 1][j - arr[i - 1]] + table[i - 1][j];
				else
					table[i][j]  = table[i - 1][j];
			}
		}
		
		return table[n][sum];
	}

}
