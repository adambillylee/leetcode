public class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0)
            return 0;
            
        if (n == 1)
            return k;
        
        int same2 = k;
        int diff2 = k * (k - 1);

        for (int i = 2; i < n; i++) {
            int tmp = same2;
            same2 = diff2;
            diff2 = tmp * (k-1) + diff2 * (k-1);
        }

        return same2 + diff2;
    }
}