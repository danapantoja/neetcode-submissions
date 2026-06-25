class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //mad hard
        //basically two pointers with an extra wrapped for loop
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        //the minus 2 decreases extra unnecessary steps
        for (int i =0;i<nums.length-2;i++){
            //needs at least one negative number to get 0
            if (nums[i]>0) break;
            //skips duplicated i
            if (i!=0 && nums[i]==nums[i-1]) continue;
            //two pointers AFTER i ELEMENT
            int j=i+1;
            int k =nums.length-1;
            while(j<k){
                List<Integer> list= new ArrayList<>();
                //if sum equals 0, add the numbers to the output list
                if (nums[i]+nums[j]+nums[k]==0){
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    output.add(list);
                    j++;
                    k--;
                    //while the j is duplicated, we keep incrementing
                    while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                    //same logic for k
                    while(j<k && nums[k]==nums[k+1]){
                        k--;
                    }
                //if the sum is less than 0, we need a greater sum, so 
                //increment j
                }else if (nums[i]+ nums[j]+nums[k]<0){
                    j++;
                //same logic for k
                }else{
                    k--;
                }
                
            }
        }
        return output;
        
    }
}
