class Solution {
    public int maxProfit(int[] prices) {
        int max =0;
        int[]minarr = new int[prices.length];
        minarr[0]=prices[0];
        for (int i =1;i<minarr.length;i++){
            minarr[i]=Math.min(minarr[i-1],prices[i]);
        }

        //each i is the selling index
        for (int i=0;i<prices.length;i++){
            int currProfit =0;
            int min =minarr[i];
            //for each index less than i, we check if the
            //profit would be 
            
            currProfit = prices[i]-min;
            max = Math.max(currProfit, max);
        }
        return max;
    }
}
