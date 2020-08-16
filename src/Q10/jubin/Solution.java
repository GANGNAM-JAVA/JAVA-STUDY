package Q10.jubin;

public class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int island_count = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == '1'){
                    check_connected_island(grid, i, j, row, col);
                    island_count += 1;
                }
            }
        }

        return island_count;
    }

    private static void check_connected_island(char[][] grid, int i, int j, int row, int col){

        if(i<0 || j<0 || i>=col || j>=row || grid[i][j]!= '1')
            return;
        grid[i][j] = '2';
        check_connected_island(grid, i+1, j, row, col);
        check_connected_island(grid, i, j+1, row, col);
        check_connected_island(grid, i-1, j, row, col);
        check_connected_island(grid, i, j-1, row, col);
    }

}