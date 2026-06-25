class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        
        dp[s.length()]=true;
        for (int i =s.length()-1;i>=0;i--){

            for (String word : wordDict){
                if ( i + word.length() <= s.length() && s.substring(i, word.length()+i).equals(word)){
                    dp[i] = dp[i+word.length()];
                }
                if(dp[i]) break;
            }
        }
        return dp[0];
        
    }
}
