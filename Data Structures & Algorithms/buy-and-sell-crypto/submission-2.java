class Solution {
    public int maxProfit(int[] prices) {
        int max =0;

        //gets the absoulte min at each index UP TO index i
        //(dp)
        int[]minarr = new int[prices.length];
        minarr[0]=prices[0];
        for (int i =1;i<minarr.length;i++){
            minarr[i]=Math.min(minarr[i-1],prices[i]);
        }

        //each i is the selling index
        for (int i=0;i<prices.length;i++){
            int currProfit =0;
            //gets the minimum buying price up to index i
            int min =minarr[i];
            //gets the profit and sees if its the max
            currProfit = prices[i]-min;
            max = Math.max(currProfit, max);
        }
        return max;
    }
}
