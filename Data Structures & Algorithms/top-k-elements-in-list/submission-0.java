class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
    
        for (int key : map.keySet()){
            if(heap.size()<k){
                heap.offer(new int[]{key, map.get(key)});

            }else{
                if (heap.peek()[1] < map.get(key)){
                    heap.poll();
                    heap.offer(new int[]{key,map.get(key)});
                }
            }
        }
        int[] output = new int[k];
        int i =0;
        while(!heap.isEmpty()){
            output[i++]=heap.poll()[0];
        }
        return output;
    }
}
