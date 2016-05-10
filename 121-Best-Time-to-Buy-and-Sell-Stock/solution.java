public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int maxPriceBefore = prices[0];
        
        for (int i=1; i<prices.length(); i++) {
            int profit = maxPriceBefore - prices[i];
            maxPriceBefore = Math.max(maxPriceBefore, prices[i]);
            
            if (profit > maxProfit)
                maxProfit = profit;
        }
        
        return maxProfit;
    }
}