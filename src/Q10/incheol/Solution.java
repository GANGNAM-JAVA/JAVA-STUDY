package Q10.incheol;

/**
 * @author Incheol Jung
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        if(grid.length == 0 ) return count;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(!visited[i][j]){
                    if(markIsland(i , j, grid, visited)){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public boolean markIsland(int x, int y, char[][] grid, boolean[][] visited){
        if(!visited[x][y] && grid[x][y] == '1'){
            visited[x][y] = true;
            if(x+1 < grid.length) markIsland(x+1, y, grid, visited);
            if(x-1 >= 0) markIsland(x-1, y, grid, visited);
            if(y+1 < grid[x].length) markIsland(x, y+1, grid, visited);
            if(y-1 >= 0) markIsland(x, y-1, grid, visited);
        }else{
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int count = sol.numIslands(new char[][]{
            {'1', '1', '1'},
            {'0', '1', '0'},
            {'1', '1', '1'}
        });

        System.out.println(count);
    }
}
