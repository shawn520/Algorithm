package offer.group3.test37;

import org.junit.Test;

import java.util.HashSet;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * 思路：用两个map存储两个链表的节点。
 * 同时遍历两个链表
 * 遍历时，先查询对方map中是否包含，如果包含则返回，
 * 否则将该节点加入自己的map
 *
 * 时间复杂度：假设第一个链表长度m, 第二个链表长度n
 * 则时间复杂度为O(m+n),而且最多遍历一次。
 *
 * @author Shawn
 * @date 2019/7/23
 */

public class Solution {

    @Test
    public void test() {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(5);
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        ListNode node = FindFirstCommonNode(node1, node2);
        System.out.println(node.val);
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (null != p1 || null != p2) {
            if(null != p1) {
                if(set2.contains(p1.val)) {
                    return p1;
                } else {
                    set1.add(p1.val);
                    p1 = p1.next;
                }
            }

            if(null != p2) {
                if(set1.contains(p2.val)) {
                    return p2;
                } else {
                    set2.add(p2.val);
                    p2 = p2.next;
                }
            }
        }
        return null;

    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
