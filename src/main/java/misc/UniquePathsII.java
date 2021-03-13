package misc;

public class UniquePathsII {

	public static void main(String[] args) {

		// int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		//int[][] obstacleGrid = { { 0, 0 }, { 1, 1 }, { 0, 0 } };
		int[][] obstacleGrid = { {0, 1} };

		System.out.println(new UniquePathsII().uniquePathsWithObstacles(obstacleGrid));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		if (obstacleGrid[m-1][n-1] == 1)
			return 0;
		
		 if (m == 1 && n == 1 && obstacleGrid[m-1][n-1] == 0) {
			 return 1;
		 }
		
		int[][] dp =new int[m][n];
		
		for (int i = n - 2; i >= 0; i--) {
			if (obstacleGrid[m-1][i] == 1)
				break;
			dp[m-1][i] = 1;
		}

		for (int i = m - 2; i >= 0; i--) {
			if (obstacleGrid[i][n-1] == 1)
				break;
			dp[i][n-1] = 1;
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				if (obstacleGrid[i][j] == 0)
					dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
			}
		}

		return dp[0][0];
	}
}
