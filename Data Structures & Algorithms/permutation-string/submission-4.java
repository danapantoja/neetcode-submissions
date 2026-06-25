class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        char[] arr = s1.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);
        
        for (int i =s1.length();i<=s2.length();i++){
            String substr = s2.substring(i-s1.length(), i);
            char[] temp = substr.toCharArray();
            Arrays.sort(temp);
            substr = new String(temp);
            if (substr.equals(sorted)){
                return true;
            }
        }
        return false;
    }
}
