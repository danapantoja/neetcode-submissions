class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i =0;i<nums.length;i++){
            dp[i] = nums.length;
        }
        dp[nums.length-1] = 0;
        for (int i =nums.length-2;i>=0;i--){
            
            for (int j=i;j<=nums[i] + i && j<nums.length;j++){
                dp[i] = Math.min(dp[i], dp[j] + 1);
            }

        }
        return dp[0];
    }
}
