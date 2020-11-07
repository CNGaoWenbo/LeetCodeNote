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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmp = dummy;
        while(tmp .next != null && tmp.next.next != null){
            ListNode n1 = tmp.next;
            ListNode n2 = n1.next;
            tmp.next = n2;//【重要】没有的话2->1[->]1'<-2' ; 1'->1''
            n1.next = n2.next;
            n2.next = n1;
            tmp = n1;
        }
        return dummy.next;
    }
}
