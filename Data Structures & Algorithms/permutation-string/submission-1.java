class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //if s1 greater than s2, return false (impossinle to be true)
        if (s1.length()>s2.length()) return false;

        //gets the characters and frequencies of s1
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i =0;i<s1.length();i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i),0)+1);
        }

        //makes a map for the first s1.length() characters in s2 and their frequencies
        HashMap<Character, Integer> copy = new HashMap<>();
        for (int i =0;i<s1.length();i++){
            copy.put(s2.charAt(i), copy.getOrDefault(s2.charAt(i),0)+1);
        }
        //if the copy map already equals the s1 map, we can return true
        if (copy.equals(map)) return true;
       
       //sliding window of fixed length s1.length()
        int left =0;
        int right = s1.length();
        
        while(right<s2.length()){
            //remove the frequency (and maybe character) of the left character
            copy.put(s2.charAt(left), copy.get(s2.charAt(left))-1);
            if (copy.get(s2.charAt(left))==0){
                copy.remove(s2.charAt(left));
            }
            //then increment left
            left++;
            //add the new right character and frequency to the map
            copy.put(s2.charAt(right),copy.getOrDefault(s2.charAt(right),0)+1);
            //increment for next iteration
            right++;
            //if the new sliding window map is equal to the map of s1, we can return true
            if (copy.equals(map)) return true;
        }
        //if we made it to the end, there is no permuation , return false
        return false;
    }
}
