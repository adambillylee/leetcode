public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2 || prices == null)
            return 0;

        // for first state (prices[0])
        int rest = 0;
        int buy = -prices[0];
        int sell = 0;

        for (int i = 1; i < prices.length; i++) {
            int last_rest = rest;
            rest = Math.max(last_rest, sell);
            
            int last_buy = buy;
            buy = Math.max(last_rest - prices[i], buy);
            
            sell = last_buy + prices[i];
        }

        return Math.max(sell, rest);
    }
}