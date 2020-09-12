package com.github.basic.archived.offer.group5.test56;

import org.junit.Test;

/**
 * 链表中环的入口结点
 * 题目描述：
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 分析：
 * 拆分为两步。判断是否有环和寻找入口节点
 * 首先判断是否有环，有则返回环的入口节点
 * 没有则输出null。
 * 判断是否有环：
 * 两个指针，同时出发，quick每次跳两格，slow每次跳一格，
 * 如果quick追上slow则说明有环。
 *
 * 寻找入口节点：
 * 同样两个指针，一个指针指向相遇点，一个指向头结点
 * 两个指针每次跳一格，相遇点极为入口节点。
 *
 * @author Shawn
 * @date 2019/8/4
 */
public class Solution {

    @Test
    public void test() {
        // 功能测试
        ListNode node1 = new ListNode(1);
        /*ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;*/
        // 是否有环
        //node6.next = node3;

        // 边界测试
        // 空链表
        // ListNode node1 = null;

        ListNode node = EntryNodeOfLoop(node1);
        System.out.println(node.val);

    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        // 判断是否有环
        Boolean circle = false;
        ListNode p = pHead;
        ListNode q = pHead;
        while (null != p && null != p.next) {
            p = p.next.next;
            q = q.next;
            if(p == q) {
                circle = true;
                break;
            }
        }

        // 如果有环，则寻找环的入口点
        if(circle) {
            p = pHead;
            while (p != q) {
                p = p.next;
                q = q.next;
            }
            return p;
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
