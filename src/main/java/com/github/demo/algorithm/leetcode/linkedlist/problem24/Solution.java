package com.github.demo.algorithm.leetcode.linkedlist.problem24;

/**
 * 剑指 Offer 24. 反转链表
 *
 * 思路：头插法
 * @author Shawn
 * @date 2021/7/5
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode head2 = new ListNode(0);
        ListNode curNode = head;
        while(curNode != null) {
            ListNode node = new ListNode(curNode.val);
            node.next = head2.next;
            head2.next = node;
            curNode = curNode.next;
        }
        return head2.next;
    }
}


/** Definition for singly-linked list. */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x ) {
      val = x;
  }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}