class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        HashMap<Character,Integer> freq = new HashMap<>();
        int freqMax = 0;

        int output =0;
        for (int r= 0;r<s.length();r++){
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0)+1);
            freqMax = Math.max(freqMax, freq.get(s.charAt(r)));

            int windowLength = (r -left)+1;
            if ( windowLength -freqMax <=k){
                output= Math.max(output, windowLength);
            }
            else{
                freq.put(s.charAt(left), freq.get(s.charAt(left))-1);
                left++;
            }
            
        }
        return output;
    }
}
