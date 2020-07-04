package dynamicprogramming.similar.knapsack;


public class KnapsackProblem {

	static Integer[][] table;
	static Integer[][] t_TopDown;

	public static void main(String[] args) {

//		Integer[] weight = { 1, 3, 4, 5 };
//		Integer[] values = { 1, 4, 5, 7 };
//		int W = 7;
		
		Integer[] weight = { 1, 3, 4, 5, 10, 2, 4, 23, 56, 33, 21, 12, 56, 11, 9, 7, 6, 34 };
		Integer[] values = { 1, 4, 5, 7, 100, 3, 6, 56, 23, 89, 67, 33, 11, 22, 424, 111, 45, 56 };
		int W = 950;

		KnapsackProblem kp = new KnapsackProblem();
		
		long endTime = 0;
		long startTime = 0;
		
		System.out.println("----------------------Recursive-------------");
		startTime = System.currentTimeMillis();
		int val = kp.recursiveProcedure(weight, values, W, weight.length);
		endTime = System.currentTimeMillis();
		System.out.println("Recursive took " + (endTime - startTime) + " milliseconds");
		System.out.println(val);

		System.out.println("----------------------Memoization------------------");
		table = new Integer[weight.length + 1][W + 1];
		startTime = System.currentTimeMillis();
		val = kp.memoizationProcedure(weight, values, W, weight.length);
		endTime = System.currentTimeMillis();
		System.out.println("Memoization took " + (endTime - startTime) + " milliseconds");
		System.out.println(val);
		
		System.out.println("----------------------TopDown-----------------------");
		t_TopDown = new Integer[weight.length+1][W+1];
		startTime = System.currentTimeMillis();
		val = kp.topDownProcedure(weight, values, W, weight.length);
		endTime = System.currentTimeMillis();
		System.out.println("TopDown took " + (endTime - startTime) + " milliseconds");
		System.out.println(val);
	}

	private int recursiveProcedure(Integer[] weight, Integer[] values, int W, int n) {

		if (n == 0 || W == 0) {
			return 0;
		}

		if (W >= weight[n - 1]) {
			return Math.max(values[n - 1] + recursiveProcedure(weight, values, W - weight[n - 1], n - 1),
					recursiveProcedure(weight, values, W, n - 1));
		} else {
			return recursiveProcedure(weight, values, W, n - 1);
		}
	}

	private int memoizationProcedure(Integer[] weight, Integer[] values, int W, int n) {

		if (n == 0 || W == 0) {
			return 0;
		}
		
		if (table[n][W] != null) {
			return table[n][W];
		} else {
			if (W >= weight[n - 1]) {
				return table[n][W] = Math.max(values[n - 1] + memoizationProcedure(weight, values, W - weight[n - 1], n - 1),
						memoizationProcedure(weight, values, W, n - 1));
			} else {
				return table[n][W] = memoizationProcedure(weight, values, W, n - 1);
			}
		}
	}
	
	private int topDownProcedure(Integer[] weight, Integer[] values, int W, int n) {

		for (int i = 0; i <n+1; i++) {
			for (int j = 0; j <W+1; j++) {
				if (i == 0 || j == 0) {
					t_TopDown[i][j] = 0;
				}
				if (i != 0 && j != 0) {
					break;
				}
			}
		}
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < W+1; j++) {
				
				if (j >= weight[i - 1]) {
					t_TopDown[i][j] = Math.max(values[i-1]+ t_TopDown[i-1][j-weight[i-1]], t_TopDown[i-1][j]);
				} else {
					t_TopDown[i][j] = t_TopDown[i-1][j];
				}
			}
		}
		
		return t_TopDown[n][W];
	}
	
}
