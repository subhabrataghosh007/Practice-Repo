package misc;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

	public static void main(String[] args) {
		Matrix01 mm = new Matrix01();

		//int[][] grid = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		int[][] grid = { { 0, 0, 0 }, { 0, 1, 0 }, {0,0,0} };
		
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(grid[i][j] +" ");
			}
			System.out.println();
		}
		
		System.out.println("\n");
		
		grid = mm.updateMatrix(grid);
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}

	public int[][] updateMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		boolean[][] visited = new boolean[m][n];
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j]== 0) {
					queue.add(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}

		while (!queue.isEmpty()) {

			int[] node = queue.poll();

			int[][] moves = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
			
			int curX = node[0];
			int curY = node[1];
			
			for (int[] move : moves) {
				int newX = curX + move[0];
				int newY = curY + move[1];
				
				if (isNeighbor(visited, newX, newY)) {
					matrix[newX][newY] = matrix[curX][curY]+1;
					visited[newX][newY] = true;
					queue.offer(new int[] {newX, newY});
				}
				
			}

		}

		return matrix;
	}
	
	boolean isNeighbor(boolean[][] visited, int x, int y) {
		int m = visited.length;
		int n = visited[0].length;
		
		if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
			return true;
		}
		return false;
	}

}