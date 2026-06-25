class Solution {
    public boolean lemonadeChange(int[] bills) {
        int currChange = 0;
        HashMap<String,Integer> map = new HashMap<>();
        map.put("five",0);
        map.put("ten",0);
        
        for (int i =0;i<bills.length;i++){
            if (bills[i]==5){
                map.put("five", map.get("five")+1);
            }else if (bills[i] ==10){
                map.put("ten", map.get("ten")+1);
                if (map.get("five")==0) return false;
                map.put("five", map.get("five")-1);
            }else{ //20
                
                
                if (map.get("ten")>=1 && map.get("five")>=1){
                    map.put("ten",map.get("ten")-1);
                    map.put("five", map.get("five")-1);
                    
                } 
                else if (map.get("five")>=3){
                    map.put("five", map.get("five")-3); 
                }else{
                    return false;
                }
            }

            
        }
        return true;
    }
}