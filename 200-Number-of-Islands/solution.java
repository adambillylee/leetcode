public class Solution {
    char [][] grid;
    int m;
    int n;
    int counter = 0;
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
            
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1') {
                    helper(i, j);
                    counter++;
                }
            }
        }
        
        return counter;
    }
    
    private void helper(int i, int j) {
        if (i<0 || j<0)
            return;
            
        if (i>m || j>n)
            return;
            
        if (grid[i][j] == '2' || grid[i][j] == '0')
            return;
            
        grid[i][j] = '2';
            
        helper(i+1, j);
        helper(i, j+1);
        helper(i-1, j);
        helper(i, j-1);
    }
}