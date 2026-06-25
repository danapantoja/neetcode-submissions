class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length()>s2.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i =0;i<s1.length();i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i),0)+1);
        }
        HashMap<Character, Integer> copy = new HashMap<>();

        for (int i =0;i<s1.length();i++){
            copy.put(s2.charAt(i), copy.getOrDefault(s2.charAt(i),0)+1);
        }

        if (copy.equals(map)) return true;
       
        int left =0;
        int right = s1.length();

        while(right<s2.length()){
            copy.put(s2.charAt(left), copy.get(s2.charAt(left))-1);
            if (copy.get(s2.charAt(left))==0){
                copy.remove(s2.charAt(left));
            }
            left++;
            copy.put(s2.charAt(right),copy.getOrDefault(s2.charAt(right),0)+1);
            right++;
            if (copy.equals(map)) return true;
        }
        return false;
    }
}
