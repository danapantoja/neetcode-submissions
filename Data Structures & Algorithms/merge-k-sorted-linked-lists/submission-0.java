/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)->Integer.compare(a.val, b.val));
        
        for (int i =0;i<lists.length;i++){
            heap.offer(lists[i]);
        }
        ListNode head = heap.poll();
        if(head.next!=null) heap.offer(head.next);
        ListNode curr = head;
        while(!heap.isEmpty()){
            curr.next = heap.poll();
            curr = curr.next;
            if (curr.next!=null) heap.offer(curr.next);
        }
        return head;
    }
}
