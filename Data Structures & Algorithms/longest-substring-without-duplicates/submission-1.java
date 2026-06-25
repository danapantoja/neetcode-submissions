class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        //sliding window
        int left =0;
        int right = 0;
        int longest =1;
        //makes a map that updates for each window
        HashSet<Character> map = new HashSet<>();
        

        while(right<s.length()){
            //gets the character at the right of the window
            char ch = s.charAt(right);
            while(map.contains(ch)){
                map.remove(s.charAt(left));
                left++;
            }
            map.add(ch);
            longest = Math.max(longest, right-left+1);
            right++;
                
         }
            
        return longest;
    }
}
