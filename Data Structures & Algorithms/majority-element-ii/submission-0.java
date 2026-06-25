class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int target = nums.length/3;
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Integer> output = new ArrayList<>();
        for (int i =0;i<nums.length;i++){
            freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
        }
        for (int key : freq.keySet()){
            if (freq.get(key) > target){
                output.add(key);
            }
        }
        return output;
        
    }
}