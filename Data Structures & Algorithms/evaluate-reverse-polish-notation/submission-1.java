class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token :tokens){
            if (token.length() > 1 ||Character.isDigit(token.charAt(0))){
                stack.push(Integer.valueOf(token));
            }
            else{
                int second = stack.pop();
                int first = stack.pop();
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
                stack.push(newest);
            }
        }
        return stack.pop();
    }
}
