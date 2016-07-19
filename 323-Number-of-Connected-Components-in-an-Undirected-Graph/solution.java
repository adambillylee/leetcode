public class Solution {
    int[] father;
    public int countComponents(int n, int[][] edges) {
        father = new int[n];
        Arrays.fill(father, -1);
        
        for (int[] pair : edges) {
            int from = pair[0];
            int to = pair[1];
            
            int x = find(from, father);
            int y = find(to, father);
            
            if (x == y)
                continue;
            
            father[x] = y;
        }
        
        int count = 0;
        for (int i : father) {
            if (i == -1)
                count++;
        }
        
        return count;
    }
    
    int find(int i, int[] father) {
        if (father[i] == -1)
            return i;
        else
            return find(father[i], father);
    }
}