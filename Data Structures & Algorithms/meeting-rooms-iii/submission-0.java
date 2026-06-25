class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Integer> available = new PriorityQueue<>();
        PriorityQueue<int[]> used = new PriorityQueue<>((a,b) -> 
    a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
);
        Arrays.sort(meetings,(a,b)->(Integer.compare(a[0],b[0])));
        int[] numMeetings = new int[n];
        for (int i = 0; i < n; i++) available.offer(i);

        for (int i =0;i<meetings.length;i++){
            int end = 0;
            int room =0;
            //while the ending time peek of the used heap is less than the current start
            while (!used.isEmpty() && used.peek()[1]<=meetings[i][0]){
                room = used.poll()[0];
                available.offer(room);
            }
            if (!used.isEmpty() && available.isEmpty()){
                end = used.peek()[1];
                room = used.peek()[0];
                used.poll();
                int newStart = end;
                int duration = meetings[i][1] - meetings[i][0];
                int newEnd = newStart + duration;
                used.offer(new int[]{room,newEnd});

                
                
            }
            else if (!available.isEmpty()){
                room = available.poll();
                used.offer(new int[]{room, meetings[i][1]});
            }
            
            
            numMeetings[room]++;
        }
        int max = 0;
        int maxRoom = 0;
        for (int i =0;i<n;i++){
            if (max<numMeetings[i]){
                max = numMeetings[i];
                maxRoom = i;
            }
        }
        return maxRoom;
        
        


    }
}