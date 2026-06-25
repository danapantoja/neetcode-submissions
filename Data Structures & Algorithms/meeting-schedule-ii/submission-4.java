/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size()==0) return 0;
        Collections.sort(intervals, (a,b)->Integer.compare(a.start,b.start));
        PriorityQueue<Interval> heap = new PriorityQueue<>((a,b)->Integer.compare(a.end,b.end));
        heap.offer(intervals.get(0));
        int maxRooms = 1;
        for (int i =1;i<intervals.size();i++){
            int earliestEnd = heap.peek().end;
            if (earliestEnd <= intervals.get(i).start){
                heap.poll();
            }
            heap.offer(intervals.get(i));
            maxRooms = Math.max(heap.size(), maxRooms);
        }
        return maxRooms;
    }
}
