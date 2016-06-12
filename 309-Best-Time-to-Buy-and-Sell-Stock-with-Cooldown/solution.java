public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2 || prices == null)
            return 0;
        
        int rest[] = new int[prices.length];
        int buy[] = new int[prices.length];
        int sell[] = new int[prices.length];

        // for first state (prices[0])
        rest[0] = 0;
        buy[0] = -prices[0];
        sell[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            rest[i] = Math.max(rest[i-1], sell[i-1]);
            buy[i] = Math.max(rest[i-1] - prices[i], buy[i-1]);
            sell[i] = buy[i-1] + prices[i];
        }

        return Math.max(sell[prices.length-1], rest[prices.length-1]);
    }
}