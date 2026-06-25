class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;

        int currSum= 0;
        int output = nums.length + 1;
        for (int right=0;right<nums.length;right++){
            currSum+=nums[right];
            while (currSum >= target){
                output = Math.min(output, right-left + 1);
                currSum-=nums[left];
                left++;
            }
        }
        if (output==nums.length +1) return 0;
        return output; 
    }
}