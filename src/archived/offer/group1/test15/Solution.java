package archived.offer.group1.test15;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
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

    @Test
    public void test() {
        ReverseList(null);
    }

    public ListNode ReverseList(ListNode list) {

        ListNode order = list;
        ArrayList<Integer> order_list = new ArrayList<>();
        while ( null != order) {
            order_list.add(order.val);
            order = order.next;
        }
        if(order_list.isEmpty()) {
            return null;
        }
        int size = order_list.size();
        ListNode p = new ListNode(order_list.get(size -1));
        ListNode head = p;

        for(int i = size -2; i >= 0; i--) {
            ListNode node = new ListNode(order_list.get(i));
            p.next = node;
            p = p.next;
        }

        return head;

    }
}
