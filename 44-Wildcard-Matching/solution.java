public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null
                || s.length() == 0 || p.length() == 0)
            return false;

        // is ith in s is matches jth in p?
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        
        dp[0][0] = true;
        for (int i=1; i<=m; i++) {
            dp[i][0] = false;
        }

        dp[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }


        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (i == 0 || j == 0)
                    continue;

                char currS = s.charAt(i - 1);
                char currP = p.charAt(j - 1);

                if (currP != '*') {
                    if (currS != currP && currP != '?') {
                        dp[i][j] = false;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}