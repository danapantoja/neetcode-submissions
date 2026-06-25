class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int [] output = new int[temperatures.length];
        stack.push(temperatures.length-1);
        for (int i =temperatures.length-2;i>=0;i--){

            while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i]){
                stack.pop();
            }
            if (!stack.isEmpty()){
                output[i]=stack.peek()-i;
            }
            stack.push(i);
        }
        return output;
    }
}
