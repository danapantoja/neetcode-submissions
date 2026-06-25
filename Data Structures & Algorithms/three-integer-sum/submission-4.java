class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        for (int i =0;i<nums.length;i++){
            if (nums[i]>0) break;
            if (i!=0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k =nums.length-1;
            while(j<k){
                List<Integer> list= new ArrayList<>();
                if (nums[i]+nums[j]+nums[k]==0){
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    output.add(list);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                    while(j<k && nums[k]==nums[k+1]){
                        k--;
                    }
                }else if (nums[i]+ nums[j]+nums[k]<0){
                    j++;
                }else{
                    k--;
                }
                
            }
        }
        return output;
        
    }
}
