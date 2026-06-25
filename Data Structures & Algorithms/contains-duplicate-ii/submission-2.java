class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> visited = new HashSet<>();
        int left =0;
        if (k >= nums.length){
            for (int i =0;i<nums.length;i++){
            if (visited.contains(nums[i])) return true;
            visited.add(nums[i]);
            
            }
            return false;
        }
        for (int i =0;i<=k;i++){
            if (visited.contains(nums[i])) return true;
            visited.add(nums[i]);
        }

        for (int i =k+1;i<nums.length;i++){
            visited.remove(nums[left]);
            if (visited.contains(nums[i]))return true;
            visited.add(nums[i]);
            left++;
        }
        return false;
    }
}