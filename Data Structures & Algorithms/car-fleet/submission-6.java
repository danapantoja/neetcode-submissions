class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] posSpeed = new int[position.length][2];
        for (int i =0;i<position.length;i++){
            posSpeed[i][0]= position[i];
            posSpeed[i][1] = speed[i];
        }
        Arrays.sort(posSpeed, Comparator.comparingInt((int[] arr) -> arr[0]).reversed());

        Stack<int[]> stack= new Stack<>();
        stack.push(posSpeed[0]);
        for (int i =1;i<posSpeed.length;i++){
            double behindTime = (double) (target - posSpeed[i][0])/posSpeed[i][1];
            int[] frontPosSpeed = stack.peek();
            double frontTime = (double) (target - frontPosSpeed[0])/frontPosSpeed[1];
            if (behindTime > frontTime){
                stack.push(posSpeed[i]);
            }
        }
        return stack.size();
    }
}
