public class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Integer> map = new HashMap();
        
        for (int i=0; i<edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            
            if (map.contains(child)) {
                map.put(child, parent);
            }else{
                return false;
            }
        }
        
        return map.size() == n;
    }
}