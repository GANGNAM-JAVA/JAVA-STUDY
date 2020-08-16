import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
	public int[] dx = new int[]{ 0, -1, 0, 1};
	public int[] dy = new int[]{-1,  0, 1, 0};

	public class MyPair {
		public int r;
		public int c;

		public MyPair(int r, int c)
		{
			this.r = r;
			this.c = c;
		}
	}

	public void bfs(char[][] grid, boolean[][] isVisited, int sr , int sc) {
		int N = grid.length;
		int M = grid[0].length;

		Queue<MyPair> q = new LinkedList<>();
		q.offer(new MyPair(sr, sc));
		isVisited[sr][sc] = true;

		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int qs = 0; qs < qSize; qs++) {
				MyPair cur = q.poll();

				for (int i = 0; i < 4; i++) {
					int nr = cur.r + dx[i];
					int nc = cur.c + dy[i];

					if (nr < 0 || nr >= N || nc < 0 || nc >= M)
						continue;
					if (isVisited[nr][nc] || grid[nr][nc] == '0')
						continue;

					isVisited[nr][nc] = true;
					q.offer(new MyPair(nr, nc));
				}
			}
		}
	}

	public int numIslands(char[][] grid) {
		if (grid.length <= 0)
			return 0;

		boolean[][] isVisited = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++)
			Arrays.fill(isVisited[0], false);

		int res = 0;


		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1' && !isVisited[i][j]) {
					bfs(grid, isVisited, i, j);
					res++;
				}
			}
		}
		return res;
	}
}
