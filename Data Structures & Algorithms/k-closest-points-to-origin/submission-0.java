class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );
        

        for (int i = 0; i < points.length; i++) {
            heap.offer(points[i]);
            if (heap.size() > k) {
                heap.poll(); //keep heap size at most k
            }
        }

        int [][]output = new int[k][2];
        int i=0;
        while(!heap.isEmpty()){
            output[i][0] = heap.peek()[0];
            output[i][1] = heap.peek()[1];
            heap.poll();
            i++;
        }
        return output;

    }
}
