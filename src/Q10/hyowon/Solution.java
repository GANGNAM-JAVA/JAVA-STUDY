package Q10.hyowon;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        }; // 1
        System.out.println(new Solution().numIslands(grid));

        char[][] grid2 = new char[][]{
                {'1','1','1','1','1','1','1'},
                {'0','0','0','0','0','0','1'},
                {'1','1','1','1','1','0','1'},
                {'1','0','0','0','1','0','1'},
                {'1','0','1','0','1','0','1'},
                {'1','0','1','1','1','0','1'},
                {'1','1','1','1','1','1','1'}
        }; // 1
        System.out.println(new Solution().numIslands(grid2));

        char[][] grid3 = new char[][]{
                {'1'},
                {'1'}
        }; // 1
        System.out.println(new Solution().numIslands(grid3));
    }

    /**
     * Runtime: 1 ms, faster than 99.93% of Java online submissions for Number of Islands.
     * Memory Usage: 42 MB, less than 73.71% of Java online submissions for Number of Islands.
     *
     * [풀이]
     * 배열을 돌면서 1을 찾으면 섬 갯수를 ++ 하고, 재귀로 상하좌우를 확인해 인접한 1을 0으로 변경
     *
     * */
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numOfIslands++;
                    sideCheck(i, j, grid);
                }
            }
        }

        return numOfIslands;
    }

    public void sideCheck(int i, int j, char[][] grid) {
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            if (j < grid[i].length - 1) sideCheck(i,j+1,grid);
            if (j > 0)                  sideCheck(i,j-1,grid);
            if (i > 0)                  sideCheck(i-1,j,grid);
            if (i < grid.length - 1)    sideCheck(i+1,j,grid);
        }
    }

}