public class Solution {
    private int[][] directions = {
            {1, 0},  //상
            {-1, 0}, //하
            {0, -1}, //좌
            {0, 1}   //우
    };

    public int execute(char[][] grid) {
        int count = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == '1'){
                    count++;
                    dfs(grid, y, x);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int y, int x) {
        if (grid[y][x] == '2') {    //visited
            return;
        }

        for (int i = 0; i < directions.length; i++) {
            if (check(grid, y+directions[i][0], x+directions[i][1])) {
                grid[y][x] = '2';
                dfs(grid, y+directions[i][0], x+directions[i][1]);
            }
        }
    }

    private boolean check(char[][] grid, int y, int x) {
        if (y < 0 || grid.length == y || x < 0 || grid[0].length == x) { // edge
            return false;
        } else if (grid[y][x] == '0') { // water
            return false;
        }
        return true;
    }
}
