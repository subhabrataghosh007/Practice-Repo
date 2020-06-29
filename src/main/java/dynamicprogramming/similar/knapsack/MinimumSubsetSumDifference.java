package dynamicprogramming.similar.knapsack;

import java.util.Vector;

/**
 * 1. Find the Subset Sum with range (which is sum of element of array)
 * 2. Fill the table used in Subset Sum
 * 3. Last row is our interest
 * 4. Find the index which present true value. (Let assume this as a list)
 * 5. Find the from the list useing (range-2*i)
 * 
 * 
 * Here  "Range - 2*i", Because,
 * 
 * We have to find two diff Subset.
 * Let say S1 and S2.
 * Range = Sum of all elements
 * S2 = Range - S1
 * 
 * That means what we have to find is:
 * 
 * S2 - S1 => MIN value
 * (Range - S1) - S1 => Min Value
 * Range - 2 * S1 => Min Value
 * 
 * */


public class MinimumSubsetSumDifference {

	public static void main(String[] args) {

		//int[] arr = { 10, 2, 6, 7 };
		int[] arr = {1, 2, 7};
		int range = 0;
		for (int i = 0; i < arr.length; i++)
			range += arr[i];
		
		MinimumSubsetSumDifference difference = new MinimumSubsetSumDifference();
		difference.topDown(arr, range);
	}
	
	private void topDown(int[] arr, int range) {
		int n = arr.length;
		Boolean[][] table = new Boolean[n+1][range+1];
		
		for (int i = 0; i < range+1; i++) {
			table[0][i] = false;
		}
		for (int i = 0; i < n+1; i++) {
			table[i][0] = true;
		}
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < range+1; j++) {
				if (j >= arr[i - 1])
					table[i][j] = table[i - 1][j - arr[i-1]] || table[i - 1][j];
				else
					table[i][j] = table[i - 1][j];
			}
		}
		
		
		int min = Integer.MAX_VALUE;
		
//		Vector<Integer> v = new Vector<Integer>();
		
		for (int i = 0; i < range+1; i++) {
			if (table[n][i]) {
				min = Math.min(min, Math.abs(range - 2*i));
//				v.add(i);
			}
		}
		
//		for (Integer i : v) {
//			min = Math.min(min, Math.abs(range - 2*i));
//		}
//		
		System.out.println("\n"+min);
		
	}

}
