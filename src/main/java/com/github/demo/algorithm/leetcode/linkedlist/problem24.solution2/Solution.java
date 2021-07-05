package com.github.demo.algorithm.leetcode.linkedlist.problem24.solution2;

/**
 * 剑指 Offer 24. 反转链表
 *
 * 思路：头插法
 * @author Shawn
 * @date 2021/7/5
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
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