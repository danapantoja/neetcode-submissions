class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> from = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        PriorityQueue<int[]> to = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        for (int i =0;i<trips.length;i++){
            from.offer(trips[i]);
            to.offer(trips[i]);
        }
        int currPassengers =0;
        int kilo = 0;
        while(!from.isEmpty() ||!to.isEmpty()){
            if (currPassengers> capacity) return false;
            kilo++;
            while (!from.isEmpty() && kilo>= from.peek()[1]) currPassengers+=from.poll()[0];
            while(!to.isEmpty() && kilo>= to.peek()[2]){
                currPassengers-=to.poll()[0];
            }
        }
        return true;

    }
}