class KthLargest {
    PriorityQueue<Integer> heap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        heap = new PriorityQueue<>((a,b)->Integer.compare(a,b));
        for(int num: nums){
            add(num);
        }
        
    }
    
    public int add(int val) {
        if(heap.size()<k){
            heap.offer(val);
        }else{
            if (val>heap.peek()){
                heap.poll();
                heap.offer(val);
            }
        }
        return heap.peek();
    }
}
