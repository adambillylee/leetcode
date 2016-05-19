public class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        
        dp[0] = 1;
        for (int i=1; i<s.length()-1;i++) {
            for (int j=i-1; j>=i-2; j++) {
                if (j<0)
                    continue;
                
                int curr = Integer.parseInt(s.substring(j,i));
        
                if (dp[j]>1 && curr >0 && curr <=26)
                    dp[i] = dp[j]+1;
            }
        }
        
        return dp[s.length()];
    }
}