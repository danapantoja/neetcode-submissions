class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] output = new int[nums.length*2];
        int n = nums.length;
        for (int i =0;i<n;i++){
            output[i] = nums[i];
            if (i + n < 2*n){
                output[i+n] = nums[i];
            }
        }
        return output;
    }
}