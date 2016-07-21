public class Solution {
    public int minTotalDistance(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        
        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        
        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        
        Collections.sort(x);
        Collections.sort(y);
        
        return getMin(x) + getMin(y);
    }
    
    private int getMin(List<Integer> list) {
        int i = 0;
        int j = list.size()-1;
        
        int dist = 0;
        while (i<j) {
            dist += list.get(j--) - list.get(i++);
        }
        
        return dist;
    }
}