class Solution {
    public int longestConsecutive(int[] nums) {
        //SET!!!!!
       Set<Integer> map = new HashSet<>();

        //add all numbers in the set
       for (int i =0;i<nums.length;i++){
            map.add(nums[i]);
       }
       int max =0;
       for(int num : nums){
            //means this number is the smallest in a
            //consequtive sequence, bc the set doesnt have
            //the number directly lower than it
            //prevents undercounting
            if (!map.contains(num-1)){
                int length =1;
                //while there is still a number in the
                //map that is consequetively greater,
                //we increment the length of the current sequence
                while (map.contains(num+length)){
                    length++;
                }
                //if the current sequence is longer than the 
                //current max we have, change the max
                max = Math.max(max, length);
            }
            
       }
    return max;
       
}
}
