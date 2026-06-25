class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length-1] = true;
        for (int i =nums.length-2;i>=0;i--){
            int maxJump = Math.min(nums.length, i + nums[i]);
            for (int j = i +1; j<=maxJump;j++){
                if (dp[j]==true){
                    dp[i] = true;
                    break;
                }
                
            }
        }
        return dp[0];

    }
}
