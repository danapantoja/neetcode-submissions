class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token :tokens){

            //checks if the token is a number
            if (token.length() > 1 ||Character.isDigit(token.charAt(0))){
                stack.push(Integer.valueOf(token));
            }
            else{

                //pops the second term first
                int second = stack.pop();
                int first = stack.pop();
                //pops first term (easier to think about)
                int newest = 0;
                if (token.equals("+")){
                    newest = first +second;

                }else if (token.equals("*")){
                    newest = first *second;
                }else if (token.equals("-")){
                    newest = first - second;

                }else{//divide
                    newest = first / second;
                }

                //after the operation, push it back into the stack
                stack.push(newest);
            }
        }
        //returns the last number after all operations
        return stack.pop();
    }
}
