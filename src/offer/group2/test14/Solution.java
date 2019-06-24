package offer.group2.test14;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author Shawn
 * @date 2019/6/24
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {

        int length = 0;
        ListNode node = head;
        while (null != node ) {
            node = node.next;
            length++;
        }

        int index = length - k;
        if(index < 0) {
            return null;
        }

        ListNode p = head;
        for( int i = 0; i < index; i++) {
            p = p.next;
        }
        return p;

    }
}
