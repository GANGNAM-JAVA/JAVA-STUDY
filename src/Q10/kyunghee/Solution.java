package problems;

public class Solution {
    private static int[][] directions = {
            {1, 0},  //상
            {-1, 0}, //하
            {0, -1}, //좌
            {0, 1}   //우
    };

    public static int execute(char[][] grid) {
        int yLen = grid.length;
        int xLen = grid[0].length;
        boolean[][] cache = new boolean[yLen][xLen];
        int count = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == '1' && cache[y][x] == false){
                    count++;
                    dfs(grid, y, x, cache);
                }
            }
        }

        return count;
    }

    private static int dfs(char[][] grid, int y, int x, boolean[][] cache) {
        if (cache[y][x]) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < directions.length; i++) {
            if (check(grid, y+directions[i][0], x+directions[i][1])) {
                cache[y][x] = true;
                dfs(grid, y+directions[i][0], x+directions[i][1], cache);
            }
        }
        return result;
    }

    private static boolean check(char[][] grid, int y, int x) {
        if (y < 0 || grid.length == y || x < 0 || grid[0].length == x) {
            return false;
        } else if (grid[y][x] == '0') { // water
            return false;
        }
        return true;
    }
}
