class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i =0;i<hand.length;i++){
            map.put(hand[i], map.getOrDefault(hand[i],0)+1);
        }
        int i = hand.length-1;

        while(i>=0){
            while (i>=0 && map.get(hand[i])<=0){
                i--;
            }
            if (i==-1) break;

            for (int j =0;j<groupSize;j++){
                if (!map.containsKey(hand[i]-j) || map.get(hand[i]-j)<=0){
                    return false;
                }
                map.put(hand[i]-j, map.get(hand[i]-j)-1);
            }
            
            i--;
        }
        return true;

    }
}
