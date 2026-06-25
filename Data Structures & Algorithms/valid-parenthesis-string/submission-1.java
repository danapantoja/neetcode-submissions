class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> stars = new Stack<>();
        Stack<Integer> open = new Stack<>();
        
        for (int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if (ch=='*'){
                stars.push(i);
            }else if (ch=='('){
                open.push(i);
            }else{ //closing
                if (open.isEmpty() && stars.isEmpty()) return false;
                
                if (open.isEmpty()){
                    stars.pop();
                }else {
                    open.pop();
                }
            }
        }

        while (!stars.isEmpty() && !open.isEmpty()){
            
            if (stars.peek()< open.peek()) return false;
            stars.pop();
            open.pop();
        }
       if (!open.isEmpty()) return false;
       return true;
    }
}
