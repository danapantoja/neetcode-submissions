class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if (ch!=']'){
                stack.push(ch);
            }else { //character is closing bracket
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty() && stack.peek()!='['){
                    temp.append(stack.pop());
                }
                //pop opening parenthesis
                stack.pop();
                StringBuilder numStr = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())){
                    numStr.append(stack.pop());
                }
                int repeat = Integer.parseInt(numStr.reverse().toString());
                StringBuilder newPush = new StringBuilder();
                String substr = temp.reverse().toString();
                for (int j =0;j<repeat;j++){
                    newPush.append(temp);
                }
                for (char c : newPush.toString().toCharArray()){
                    stack.push(c);
                }

            }
        }
        StringBuilder output = new StringBuilder();
        while (!stack.isEmpty()){
            output.append(stack.pop());
        } 
        return output.reverse().toString();
    }
}