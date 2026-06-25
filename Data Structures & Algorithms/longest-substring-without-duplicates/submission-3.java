class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> visited = new HashSet<>();
        int longest =0;
        int left = 0;
        for (int right =0;right<s.length();right++){
            
            while (visited.contains(s.charAt(right))){
                visited.remove(s.charAt(left));
                left++;
            }
            visited.add(s.charAt(right));
            longest = Math.max(right - left + 1, longest);
        }
        return longest;
    }
}
