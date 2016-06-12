public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2 || prices == null)
            return 0;

        // for first state (prices[0])
        int before_buy = 0;
        int before_sell = -prices[0];
        int after_sell = 0;

        for (int i = 1; i < prices.length; i++) {
            int tmp = before_buy;
            before_buy = Math.max(before_buy, after_sell);

            after_sell = before_sell + prices[i];
            before_sell = Math.max(tmp - prices[i], before_sell);
        }

        return Math.max(after_sell, before_buy);
    }
}