class Solution {
    public int maxProfit(int[] prices) {
        int max =0;

        for (int i=0;i<prices.length;i++){
            int currProfit =0;
            int min =prices[i];
            for (int j =0;j<i;j++){
                min = Math.min(min,prices[j]);
            }
            currProfit = prices[i]-min;
            max = Math.max(currProfit, max);
        }
        return max;
    }
}
