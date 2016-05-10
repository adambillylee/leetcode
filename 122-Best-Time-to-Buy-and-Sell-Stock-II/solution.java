public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        
        int boughtPrice = prices[0];
        int profit = 0;
        
        for (int i=1; i<prices.length; i++) {
            if (prices[i] > boughtPrice) {
                profit += prices[i] - boughtPrice;
            }
            
            boughtPrice = prices[i];
        }
        
        return profit;
    }
}