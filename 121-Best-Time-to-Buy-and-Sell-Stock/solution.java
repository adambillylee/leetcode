public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        
        int maxProfit = 0;
        int minPriceBefore = prices[0];
        
        for (int i=1; i<prices.length; i++) {
            int profit = prices[i] - maxPriceBefore;
            minPriceBefore = Math.min(maxPriceBefore, prices[i]);
            maxProfit = Math.max(maxProfit, profit);
        }
        
        return maxProfit;
    }
}