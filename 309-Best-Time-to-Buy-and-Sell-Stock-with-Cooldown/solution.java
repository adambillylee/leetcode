public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2 || prices == null)
            return 0;

        int rest = 0, buy = -prices[0], sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int last_buy = buy;
            buy = Math.max(buy, rest - prices[i]);

            int last_sell = sell;
            sell = Math.max(sell, prices[i] + last_buy);
            rest = Math.max(rest, last_sell);
        }

        return Math.max(rest, sell);
    }
}