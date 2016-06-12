public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2 || prices == null)
            return 0;

        // for first state (prices[0])
        int rest = 0;
        int buy = -prices[0];
        int sell = 0;

        for (int i = 1; i < prices.length; i++) {
            int tmp = rest;
            rest = Math.max(rest, sell);

            sell = buy + prices[i];
            buy = Math.max(tmp - prices[i], buy);
        }

        return Math.max(sell, rest);
    }
}