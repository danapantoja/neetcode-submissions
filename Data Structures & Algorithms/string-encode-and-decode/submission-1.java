class Solution {

    public String encode(List<String> strs) {
        //make result string builder to encode
        StringBuilder result = new StringBuilder();
        //encode the length of the word at the beginning 
        //followed by a pound sign, then the actual word
        for (String s : strs){
            result.append(s.length()).append('#').append(s);
        }
        //return the result string
        return result.toString();
    }

    public List<String> decode(String str) {
        //list decoding 
        List<String> result = new ArrayList<>();
        int i =0;
        while (i <str.length()){
            //two pointers, increment j until we reach the pound sign
            int j = i;
            while (str.charAt(j)!='#'){
                j++;
            }
            //then the index from i to j is the LENGTH 
            //of how much we add to the result AFTER the pound sign
            String len = str.substring(i,j);
            //string to int gets the length of the substring to add
            int length = Integer.parseInt(len);

            //then increment i to j +1 (start of the substring to add)
            i= j +1;
            //end of the substring to add
            j = i +length; //doesnt include the last index
            result.add(str.substring(i,j));
            //make i the character AFTER the substring , then do the process again
            i =j;
        }
        return result;

    }
}
