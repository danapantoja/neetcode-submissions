class Solution {
    public String predictPartyVictory(String senate) {

        //store INDICES
        Queue<Integer> diresLeft = new LinkedList<>();
        Queue<Integer> radiantsLeft = new LinkedList<>();
        //populate both queues
        for (int i =0;i<senate.length();i++){
            char ch = senate.charAt(i);
            if (ch=='R'){
                radiantsLeft.offer(i);
            }else{
                diresLeft.offer(i);
            }
        }

        while (!diresLeft.isEmpty()&& !radiantsLeft.isEmpty()){
            int direIndex = diresLeft.poll();
            int radiantIndex = radiantsLeft.poll();

            if (direIndex < radiantIndex){
                diresLeft.offer(direIndex +senate.length());
            }else{
                radiantsLeft.offer(radiantIndex + senate.length());
            }
        }
        if (diresLeft.isEmpty()){
            return "Radiant";
        }
        return "Dire";
    }
}