public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int buy = -prices[0];
        int rest = 0;
        int sell = 0;

        for (int i = 1; i < prices.length; i++) {
            int tmp = buy;
            buy = Math.max(buy, rest - prices[i]);

            // if (i >= 2)
                rest = Math.max(sell, rest);

            // if (i >= 1)
                sell = tmp + prices[i];
        }

        return Math.max(rest, sell);
    }
}