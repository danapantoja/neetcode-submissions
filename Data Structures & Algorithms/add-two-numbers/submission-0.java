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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = new ListNode();
        head.next = curr;

        int carry =0;
        while (l1!=null || l2!=null || carry!=0){
            int nextVal = 0;
            if (l1!=null){
                nextVal+=l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                nextVal+=l2.val;
                l2 = l2.next;
            }
            nextVal+=carry;
            carry = nextVal/10;
            curr.val = nextVal%10;
            if (l1!=null || l2!=null || carry!=0){
                curr.next = new ListNode();
            }
            curr = curr.next;
        }

        return head.next;
    }
}
