class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0,1);
        int count =0;
        int currPrefix =0;
        for (int i =0;i<nums.length;i++){
            currPrefix+=nums[i];
            count+=prefix.getOrDefault(currPrefix- k,0);
            prefix.put(currPrefix, prefix.getOrDefault(currPrefix,0)+1);
        }
        return count;
    }
}