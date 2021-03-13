package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottenOrange {

	static final int EMPTY_CELL = 0;
    static final int FRESH = 1;
    static final int ROTTEN = 2;
	
	public static void main(String[] args) {

		//Integer[][] grid = { { 0, 1, 1, 0, 1 }, { 2, 1, 0, 1, 0 }, { 0, 2, 0, 0, 1 }, { 0, 2, 0, 0, 0 } };
		Integer[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

		RottenOrange z = new RottenOrange();

		int m = grid.length;
		int n = grid[0].length;

		System.out.println(z.minHours(m, n, grid));
	}

	int minHours(int rows, int columns, Integer[][] grid) {

		int minutes = 0;
		Queue<Node> queue = new LinkedList<>();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (grid[i][j] == ROTTEN) {
					queue.add(new Node(i, j, 0));
				}
			}
		}

		while (!queue.isEmpty()) {
			Node zombie = queue.poll();

			minutes = Math.max(minutes, zombie.minutes);
			
			int[][] moves = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
			
			for (int i = 0; i < moves.length; i++) {
				int nextX = zombie.x+moves[i][0];
				int nextY = zombie.y+moves[i][1];
				
				if (isNeighbor(grid, nextX, nextY)) {
					Node turnedZombie = new Node(nextX, nextY, zombie.minutes+1);
					queue.add(turnedZombie);
					grid[nextX][nextY] = ROTTEN;
				}
			}
		}

		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (grid[i][j] == FRESH) {
					return -1;
				}
			}
		}
		
		return minutes;

	}

	boolean isNeighbor(Integer[][] grid, int i, int j) {
		if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == FRESH) {
			return true;
		}
		return false;
	}

	static class Node {
		int x, y;
		int minutes;

		public Node(int x, int y, int minutes) {
			this.x = x;
			this.y = y;
			this.minutes = minutes;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", minutes=" + minutes + "]";
		}
		
	}
}
