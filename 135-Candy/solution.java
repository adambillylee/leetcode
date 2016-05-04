public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int leftToR[] = new int[n];
        int rightToL[] = new int[n];
        
        leftToR[0] = 1;
        for (int i=1; i<n; i++) {
            int curr = ratings[i];
            
            if (ratings[i-1] < ratings[i])
                leftToR[i] = leftToR[i-1]+1;
            else
                leftToR[i] = 1;
        }
        
        rightToL[n-1] = 1;
        for (int i=n-2; i>=0; i--) {
            int curr = ratings[i];
            
            if (ratings[i+1] < ratings[i])
                rightToL[i] = rightToL[i+1]+1;
            else
                rightToL[i]=1;
        }
        
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += Math.max(leftToR[i], rightToL[i]);
        }
        
        return sum;
    }
}