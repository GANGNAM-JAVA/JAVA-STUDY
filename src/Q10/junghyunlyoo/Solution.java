package Q10.junghyunlyoo;
/*
 * @USER JungHyun
 * @DATE 2020-08-16
 * @DESCRIPTION
 */

public class Solution {

    private void dfs(char[][] grid, int i, int j) {
        boolean isArrayEmpty = i < 0 || j < 0;
        boolean isArrayFullyChecked = i >= grid.length || j >= grid[0].length;
        if (isArrayEmpty || isArrayFullyChecked) {
            return;
        }
        boolean isLand = grid[i][j] != '1';
        boolean isChecked = grid[i][j] == '#';
        if (isLand || isChecked) {
            return;
        }

        grid[i][j] = '#';

        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

    public int numIslands(char[][] grid) {
        int islandsCount = 0;
        int iLength = grid.length;
        int jLength = grid[0].length;
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
