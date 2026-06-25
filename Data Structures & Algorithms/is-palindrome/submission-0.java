class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder cleaned =new StringBuilder();

        for (int i =0;i<s.length();i++){
            if (alphaNum(s.charAt(i))){
                cleaned.append(s.charAt(i));
            }
        }
            
        String cleaned1 = cleaned.toString().toLowerCase();
        int left =0;
        int right = cleaned1.length()-1;
        while (left<right){
            if (cleaned1.charAt(left)!=cleaned1.charAt(right)) return false;
            left++;
            right--;
        }
        return true;



    }
    public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' || 
                c >= 'a' && c <= 'z' || 
                c >= '0' && c <= '9');
    }
}
