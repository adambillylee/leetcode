public class Solution {
        if (prices.length < 2 || prices == null)
            return 0;

        // for first state (prices[0])
        int before_buy = 0;
        int before_sell = -prices[0];
        int after_sell = 0;

        for (int i = 1; i < prices.length; i++) {
            int tmp = before_buy;
            before_buy = Math.max(before_buy, before_buy - prices[i]);

            after_sell = Math.max(before_sell, before_sell + prices[i]);
            before_sell = Math.max(before_buy, tmp);
        }

        return Math.max(before_sell, after_sell);
}