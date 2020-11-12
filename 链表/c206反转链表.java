/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//已多次练习（3）
//b->c 11/12
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode nextTemp = curr.next;
        while(curr != null){
            nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
