快指针走2步，慢指针走1步，快慢指针相遇后把快指针放回头节点，快指针和慢指针都走1步，快慢指针再次相遇点即是环的起点
- 证明： 慢指针的路程 x -> x+y+x, 快指针的路程2(x+l-y) -> 2(x+l+y)+x?
- 是否有环
``` java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(fast == null) return false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
```
- 是否有环且指出在哪里是环的起点
``` java
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
            if(fast != null){
                fast = fast.next;
            }else{
                return null;
            }
            if(fast == slow){
                fast = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;                    
                }
                return fast;
            }
        }
        return null;
```
