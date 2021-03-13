package misc;

public class UniquePaths {

	public static void main(String[] args) {

		System.out.println(new UniquePaths().uniquePaths(4,4));
		
	}

	public int uniquePaths(int m, int n) {

		int[][] ways = new int[m][n];
		ways[m - 1][n - 1] = 0;

		for (int i = m - 2; i >= 0; i--) {
			ways[i][n-1] = 1;
		}
		for (int i = n - 1; i >= 0; i--) {
			ways[m-1][i] = 1;
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				ways[i][j] = ways[i][j + 1] + ways[i + 1][j];
			}
		}

		return ways[0][0];
	}
}
