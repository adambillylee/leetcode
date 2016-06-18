public class Solution {
    char [][] guid;
    int m;
    int n;
    int counter = 0;
    
    public int numIslands(char[][] grid) {
        if (guid.length == 0 || guid[0].length == 0)
            return 0;
            
        this.guid = guid;
        this.m = guid.length;
        this.n = guid[0].length;
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (guid[i][j] == '1') {
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
            
        if (guid[i][j] == '2' || guid[i][j] == '0')
            return;
            
        guid[i][j] = '2';
            
        helper(i+1, j);
        helper(i, j+1);
        helper(i-1, j);
        helper(i, j-1);
    }
}