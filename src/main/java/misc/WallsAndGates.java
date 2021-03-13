package misc;

public class WallsAndGates {
	public static void main(String[] args) {

		int I = Integer.MAX_VALUE - 1;
		int[][] rooms = { { I, -1, 0, I }, { I, I, I, -1 }, { I, -1, I, -1 }, { 0, -1, I, I } };

		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				System.out.print(rooms[i][j] +" ");
			}
			System.out.println();
		}
		
		
		WallsAndGates w = new WallsAndGates();
		
		w.wallsAndGate(rooms);
		
		System.out.println("\n");
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				System.out.print(rooms[i][j] +" ");
			}
			System.out.println();
		}
	}

	public void wallsAndGate(int[][] rooms) {
		
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				if (rooms[i][j] == 0) {
					dfs(i, j, 0, rooms);
				}
			}
		}
	}
	
	private void dfs(int i, int j, int count, int[][] rooms) {
		if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < count)
			return;
		
		rooms[i][j] = count;
		
		dfs(i, j-1, count+1, rooms);
		dfs(i, j+1, count+1, rooms);
		dfs(i-1, j, count+1, rooms);
		dfs(i+1, j, count+1, rooms);
	}
}
