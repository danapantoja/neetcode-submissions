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
            //while the current windo1 contains ch
            while(map.contains(ch)){
                //we remove the left character
                map.remove(s.charAt(left));
                //and shrink the window
                left++;
            }
            //then after we removed ch, we add it again
            //since the right part is ch
            map.add(ch);
            //and we update the longest
            longest = Math.max(longest, right-left+1);
            //increment right to check the next character
            right++;
                
         }
            
        return longest;
    }
}
