public class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty())
            return 0;

        int dp[] = new int[s.length() + 1];

        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= i - 2; j--) {
                if (j < 0)
                    continue;

                String curr = s.substring(j, i);

                if (dp[j] > 0 && valid(curr))
                    dp[i] += dp[j];
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

        if (number < 0 || number > 26)
            return false;

        return true;
    }
}