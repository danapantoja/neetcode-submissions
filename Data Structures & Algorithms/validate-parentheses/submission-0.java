class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack =new Stack<>();
        String open ="({[";
        String close=")}]";
        for (Character c: s.toCharArray()){
            if (open.indexOf(c)!=-1){
               
                stack.push(c);
            }
            else if (close.indexOf(c)!=-1){
                if (stack.isEmpty()){
                    return false;
                }
                else if(close.indexOf(c)!=open.indexOf(stack.peek())){
                    return false;
                }
                stack.pop();
                
            }
        }
        return stack.isEmpty();
    }
}
