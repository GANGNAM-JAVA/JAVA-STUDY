package Q10.junghyunlyoo;
/*
 * @USER JungHyun
 * @DATE 2020-08-16
 * @DESCRIPTION
 */

public class Solution {

    private boolean isIsland(char[][] grid, int i, int j) {
        boolean isArrayEmpty = i < 0 || j < 0;
        boolean isArrayFullyChecked = i >= grid.length || j >= grid[0].length;
        if (isArrayEmpty || isArrayFullyChecked) {
            return false;
        }
        return grid[i][j] == '1';
    }

    private void dfs(char[][] grid, int i, int j) {
        if (!isIsland(grid, i, j)) {
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public int numIslands(char[][] grid) {
        int iLength;
        int jLength;
        if ((iLength = grid.length) == 0 ||
                (jLength = grid[0].length) == 0) {
            return 0;
        }
        int islandsCount = 0;
        for (int i = 0; i < iLength; i++) {
            for (int j = 0; j < jLength; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islandsCount++;
                }
            }
        }

        return islandsCount;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        Solution solution = new Solution();
        int result = solution.numIslands(grid);
        System.out.println("result :: " + result);
    }
}
