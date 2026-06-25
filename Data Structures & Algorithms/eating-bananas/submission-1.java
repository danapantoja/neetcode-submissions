class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int i =0;i<piles.length;i++){
            right = Math.max(right, piles[i]);
        }
        int currOutput = right;
        while(left <= right){
            int mid = (left + right) /2;
            int temp = helper(piles, mid);
            if (temp<=h){
                currOutput = mid;
                right = mid-1;
            }else{
                left= mid + 1;
            }
            
        }

        return currOutput;
    }

    public int helper (int[] arr, int rate){
        int output = 0;
        for (int i =0;i<arr.length;i++){
            output+=(arr[i] + rate - 1) / rate;
        }
        return output;
    }
}
