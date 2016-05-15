public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return -1;

        int dp[] = new int[amount + 1];
        // initiate dp
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
        }

        // make a set of coins to achieve O(1) search time
        Set<Integer> set = new HashSet<>();
        for (int coin : coins)
            set.add(coin);

        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j <i; j++) {
                /**
                 * if there is a way to make up j and there is coin to add j up to i
                 */
                if (dp[j] > -1 && set.contains(i - j)) {
                    // if this is the first combination for i, update it with dp[j]+1
                    if (dp[i] == -1) {
                        dp[i] = dp[j] + 1;
                    } else {
                        // if there are other combination for i already, update it with the min
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[amount];
    }
}