class Solution {
    public void sortColors(int[] nums) {
        int i =0;
        int k = nums.length-1;
        int j =0;
        while(j<=k){
            if (nums[j]==0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }else if (nums[j] ==2){
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                k--; //then we have to check the value that we swapped from k (bc we wont ever look at it again)
            }else{
                j++;
            }
        }
    }
    
}