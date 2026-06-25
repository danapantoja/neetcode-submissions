class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i =0;i<tasks.length;i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
        }
        //max heap
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        //queue
        Queue<int[]> queue = new LinkedList<>();
        //keeps track of time
        int time =0;

        //add the frequencies of each letter to the heap (max freq as root)
        for (char letter: map.keySet()){
            heap.offer(map.get(letter));
        }

        //need both to be empty to return time
        while (!heap.isEmpty()|| !queue.isEmpty()){
            time++;

            //if the heap isnt empty, then we can get the max freq 'add' to the schedule
            if (!heap.isEmpty()){
                int freq = heap.poll();
                //then freq goes down (because we added one to schedule)
                freq--;

                //if we still have more of this letter , we add to queue
                //with the time we can add to the heap again
                if (freq>0){
                    queue.offer(new int[]{freq,time+n});
                }
            }
            //if the queue isnt empty and the fronr is finally able to add to the heap
            //again
            if (!queue.isEmpty() && queue.peek()[1]==time){
                //we add to heap
                heap.offer(queue.poll()[0]);
            }
            
        }
        return time;


    }
}
