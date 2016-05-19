public class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        
        dp[0] = 1;
        for (int i=1; i<s.length()-1;i++) {
            for (int j=i-1; j>=i-2; j++) {
                if (j<0)
                    continue;
                
                String curr = s.substring(j,i);
        
                if (dp[j]>1 && valid(curr))
                    dp[i] = dp[j]+1;
            }
        }
        
        return dp[s.length()];
    }
    
    boolean valid(String curr) {
        if (curr.isEmpty())
            return false;
            
        if (curr.charAt(0) == '0')
            return false;
        
        int number = Integer.parseInt(curr);
        
        if (curr<0 || curr >26)
            return false;
            
        return true;
    }
}