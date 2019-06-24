package offer.group2.test16;

import java.util.List;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则.
 * @author Shawn
 */
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {


        ListNode node = list1;


        ListNode result = node;

        ListNode p = list1;
        ListNode q = list2;

        while (null != p && null != q) {
            if(p.val <= q.val) {
                node = p;
                node = node.next;
                p = p.next;
            } else {
                node = q;
                node = node.next;
                q = q.next;
            }
        }

        while (null != p) {
            node = p;
            node = node.next;
            p = p.next;
        }

        while (null != q) {
            node = q;
            node = node.next;
            q = q.next;
        }

        return result;

    }
}
