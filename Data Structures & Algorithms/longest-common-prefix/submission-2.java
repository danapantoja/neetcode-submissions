class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) return "";
        StringBuilder prefix = new StringBuilder();
        for (int i =0;i<strs[0].length();i++){
            char ch = strs[0].charAt(i);
            for (int j = 1;j<strs.length;j++){
                if (strs[j].length() <=i || strs[j].charAt(i)!=ch) return prefix.toString();
            }
            prefix.append(ch);
        }
        return prefix.toString();
    }
}