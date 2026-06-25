class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //important question, hashing

        HashMap<String, List<String>>res = new HashMap<>();

        //for each string, we sort the characters and see if the sorted version is in the map
        //if it is, we add the string to the value(array list) of the key of the sorted string
        for (String str : strs){
            char[] charr= str.toCharArray();
            Arrays.sort(charr);
            String sorted= new String(charr);
            res.putIfAbsent(sorted, new ArrayList<>());

            res.get(sorted).add(str);

        }

        return new ArrayList<>(res.values());

        
    }
}
