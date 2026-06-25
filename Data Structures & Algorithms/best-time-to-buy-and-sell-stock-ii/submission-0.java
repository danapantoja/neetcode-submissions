class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = prices.length-1;i>0;i--){
            if (prices[i] >prices[i-1]){
                profit+= prices[i]- prices[i-1];
            }
        }
        return profit;
    }
}