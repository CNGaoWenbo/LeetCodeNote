//谜一样的题意...
//篡改自己的值假装自己是下一个节点，然后删掉下一个节点，鸠占鹊巢
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
