class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i =0;i<asteroids.length;i++){
           boolean push = true;

           int curr  = asteroids[i];

           //they can only collide if they are different signs
            while (!stack.isEmpty() && (stack.peek()>0 && curr<0 ) ){
                if (Math.abs(stack.peek())>= Math.abs(curr)){
                    if (Math.abs(stack.peek())==Math.abs(curr)) stack.pop();
                    push = false;
                    break;
                }
                stack.pop();
            }
            if (push){
                stack.push(curr);
            }

        }


        //in the end, the stack is what we want to output
        int[] output = new int[stack.size()];
        int i =output.length-1;
        while (!stack.isEmpty()){
            output[i--] = stack.pop();
        }
        return output;
    }
}