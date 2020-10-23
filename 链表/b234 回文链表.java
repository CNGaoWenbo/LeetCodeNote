/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        int i = 0;
        int j = 0;
        ListNode dummy = head;
        ListNode middle = head;
        while(head != null && head.next != null){
            middle = middle.next;
            head = head.next.next;
        }
        head = dummy;
        ListNode tail = reverseList(middle);
        boolean res = true;
        while(tail != null){
            if(head.val != tail.val) res = false;
            head = head.next;
            tail = tail.next;
        }
        reverseList(middle);
        return res;
    }

    public ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}


/*
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        List list = new ArrayList();
        int j = 0;
        while(head != null){//把链表值放入链表
            list.add(head.val);
            head = head.next;
            j ++;//计数长度，尾指针
        }
        int i = 0;//头指针
        while(i < j){//逐一比较
            if(!list.get(i).equals(list.get(j-1))) return false;//不可用==！
            i ++;
            j --;
        }
        return true;

    }
}*/
