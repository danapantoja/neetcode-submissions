class Solution {
    public int characterReplacement(String s, int k) {

        //sliding window
        int left = 0;
        //gets the frequency at each window
        HashMap<Character,Integer> freq = new HashMap<>();
        //gets the max frequency at each window
        int freqMax = 0;
        //gets the max window length
        int output =0;

        //right pointer keeps going
        for (int r= 0;r<s.length();r++){
            //puts the character at the right pointer in the frequency map
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0)+1);
            //updates the max frquency from this new character
            freqMax = Math.max(freqMax, freq.get(s.charAt(r)));

            //gets the windowlength
            int windowLength = (r -left)+1;
            //if the window length - letter with max frequency is still less than 2, we
            //can continue to expand the windoe (keep the left pointer)
            //and update the output if the windowlength is greater than current max
            if ( windowLength -freqMax <=k){
                output= Math.max(output, windowLength);
            }
            else{
                //if the window length - max frequency is more than 2, it is not valid 
                //(cant change k characters to make them all the same )
                //so remove 1 from the left pointer's character, and update left to the next pointer
                freq.put(s.charAt(left), freq.get(s.charAt(left))-1);
                left++;
                //freqMax doesnt need to change
            }
            
        }
        //return the largest window we were able to get
        return output;
    }
}
