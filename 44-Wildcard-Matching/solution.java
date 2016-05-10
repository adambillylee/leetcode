public class Solution {
    boolean dp[][];
    
    public boolean isMatch(String s, String p) {
        if (s == null || p == null || s.length() == 0 || p.length() == 0)
            return false;
        
        dp = new boolean[s.length()][p.length()];
        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<p.length(); j++) {
                dp[i][j] = -1;
            }
        }
        
        
        return helper(s, p, 0, 0);
    }
    
    public boolean helper(String s, String p, int indS, int indP) {
        if (dp[indS][indP] == 1)
            return true;
            
        if (dp[indS][indP] == 0)
            return false;
        
        if (indP == p.length())
            return indS == s.length();
            
        if (p.charAt(indP) != '*') {
            if (!match(s, p, indS, indP)) {
                dp[indS][indP] == 0;
                return false;
            }else{
                return helper(s, p, indS+1, indP+1);
            }
        }else{
            if (helper(s, p, indS, indP+1)) {
                dp[indS][indP] == 1;
                return true;
            }
                
            while (match(s, p, indS, indP)) {
                if (helper(s, p, ++indS, indP+1)) {
                    dp[indS][indP] == 1;
                    return true;
                }
            }
            
            dp[indS][indP] == 0;
            return false;
        }
    }
    
    private boolean match(String s, String p, int indS, int indP) {
        if (indS >= s.length()) {
            return false;
        }
        
        if (p.charAt(indP) == s.charAt(indS)) {
            return true;
        }
            
        if (p.charAt(indP) == '?') {
            return true;
        }
            
        if (p.charAt(indP) == '*') {
            return true;
        }
            
        return false;
    }
}