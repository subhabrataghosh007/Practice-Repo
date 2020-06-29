package dynamicprogramming.similar.knapsack;

public class EqualSumPartitionProblem {
	
	static Boolean[][] table;

	public static void main(String[] args) {
		
		EqualSumPartitionProblem problem = new EqualSumPartitionProblem();
		
		int[] arr = { 10, 2, 6, 7, 1 };
		boolean val;
		
		int calulateSum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			calulateSum += arr[i];
		}
		System.out.println(calulateSum);
		
		if (calulateSum % 2 != 0)
			System.out.println("Not Possible");
		else {
			calulateSum = calulateSum/2;
			int n = arr.length;
			
			System.out.println("----------------------Recursive----------------------");
			val = problem.recursion(arr, n, calulateSum);
			System.out.println(val);
			
			System.out.println("----------------------Memoization----------------------");
			table = new Boolean[n+1][calulateSum+1];
			val = problem.memoization(arr, n, calulateSum);
			System.out.println(val);
			
			System.out.println("----------------------TopDown-----------------------");
			val = problem.topDown(arr, n, calulateSum);
			System.out.println(val);
		}
	}
	
	private boolean recursion(int arr[], int n, int sum) {
		
		if (sum == 0)
			return true;
		
		if (n == 0 && sum != 0)
			return false;
		
		if (sum  >= arr[n - 1])
			return recursion(arr, n -1, sum - arr[n - 1]) || recursion(arr, n - 1, sum);
		else
			return recursion(arr, n - 1, sum);
	}

	private boolean memoization(int arr[], int n, int sum) {
		
		if (sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;
		
		if (sum >= arr[n - 1])
			return table[n][sum] = memoization(arr, n - 1, sum - arr[n - 1]) || memoization(arr, n - 1, sum);
		else
			return table[n][sum] = memoization(arr, n-1, sum);
	}
	
	private boolean topDown(int arr[], int n, int sum) {
		
		Boolean[][] table = new Boolean[n+1][sum+1];
		
		for (int i = 0; i < sum+1; i++) {
			table[0][i] = false;
		}
		for (int j = 0; j < n+1; j++) {
			table[j][0] = true;
		}
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < sum+1; j++) {
				
				if (j >= arr[i - 1])
					table[i][j] = table[i - 1][j - arr[i - 1]] || table[i - 1][j];
				else
					table[i][j] = table[i - 1][j];
			}
		}
		
		return table[n][sum];
	}
}
