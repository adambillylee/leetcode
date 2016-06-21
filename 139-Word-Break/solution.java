public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || wordDict == null || wordDict.size() == 0)
            return false;

        int len = s.length();

        // up to ith char in s is separable in wordDict
        boolean dp[] = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j]) {
                    String curr = s.substring(j, i);

                    if (wordDict.contains(curr)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[s.length()];
    }
}