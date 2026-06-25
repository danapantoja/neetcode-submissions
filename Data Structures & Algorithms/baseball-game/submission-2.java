class Solution {
    public int calPoints(String[] operations) {
        Stack<String> stack = new Stack<>();
        for (int i =0;i<operations.length;i++){
           
            if(operations[i].equals("+")){
                if(!stack.isEmpty() && stack.size()>=2){
                String store = stack.pop();
                int add = Integer.parseInt(stack.peek());
                stack.push(store);
                stack.push(String.valueOf(add + Integer.parseInt(stack.peek())));
                }
            }else if(operations[i].equals("D")){
                if(!stack.isEmpty()){
                    stack.push(String.valueOf(Integer.parseInt(stack.peek())*2));
                }
                
            }else if (operations[i].equals("C")){
                if(!stack.isEmpty()){
                stack.pop();
                }
            }else{
                stack.push(operations[i]);
            }
        }
        int sum =0;
        while(!stack.isEmpty()){
            sum+=Integer.parseInt(stack.pop());
        }
        return sum;
    }
}