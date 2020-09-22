class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i ++){
            if(prices[i] < minPrice) minPrice = prices[i];
            int tmp = prices[i] - minPrice;
            if(tmp > maxProfit) maxProfit = tmp;
        }
        return maxProfit;
    }
}
