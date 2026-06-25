class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i =0;i<tasks.length;i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
        }
        //max heap
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        Queue<int[]> queue = new LinkedList<>();
        int time =0;
        for (char letter: map.keySet()){
            heap.offer(map.get(letter));
        }

        while (!heap.isEmpty()|| !queue.isEmpty()){
            time++;
            if (!heap.isEmpty()){
                int freq = heap.poll();
                freq--;
                if (freq>0){
                    queue.offer(new int[]{freq,time+n});
                }
            }
            if (!queue.isEmpty() && queue.peek()[1]==time){
                heap.offer(queue.poll()[0]);
            }
            
        }
        return time;


    }
}
