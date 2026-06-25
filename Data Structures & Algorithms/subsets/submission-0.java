class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(output, new ArrayList<Integer>(), nums, 0);
        return output;
    }

    public void backtrack (List<List<Integer>> output, List<Integer> curr, int[] nums, int index){
        if (index ==nums.length){
            output.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        backtrack(output, curr, nums, index +1);
        curr.remove(curr.size()-1);
        backtrack(output, curr, nums, index +1);
        
    }
}

