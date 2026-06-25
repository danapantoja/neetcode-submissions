class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i =0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        List<Integer> output = new ArrayList<>();
        
        Set<Character> visited = new HashSet<>();
        int currLen=0;
        for (int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.get(s.charAt(i))-1);
            visited.add(s.charAt(i));
            currLen++;
            if (map.get(s.charAt(i))==0){
                if (visited.size()==1){
                    output.add(currLen);
                    currLen=0;
                    
                    map.remove(s.charAt(i));
                }
                visited.remove(s.charAt(i));
            }
            
        }
        return output;
    }
}
