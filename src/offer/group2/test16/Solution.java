package offer.group2.test16;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则.
 * @author Shawn
 */
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(null == list1) {
            return list2;
        }

        if(null == list2) {
            return list1;
        }

        ListNode p = list1;
        ListNode q = list2;

        ListNode result;
        if(p.val <= q.val) {
            result = new ListNode(p.val);
            p = p.next;
        } else {
            result = new ListNode(q.val);
            q = q.next;
        }
        ListNode r = result;

        while (null != p && null !=q) {
            if(p.val <= q.val) {
                ListNode node = new ListNode(p.val);
                r.next = node;
                // 注意r指针的后移
                r = r.next;
                p = p.next;
            } else {
                ListNode node = new ListNode(q.val);
                r.next = node;
                r = r.next;
                q = q.next;
            }
        }

        while (null != p) {
            ListNode node = new ListNode(p.val);
            r.next = node;
            r = r.next;
            p = p.next;
        }

        while (null != q) {
            ListNode node = new ListNode(q.val);
            r.next = node;
            r = r.next;
            q = q.next;
        }
        return result;

    }
}
