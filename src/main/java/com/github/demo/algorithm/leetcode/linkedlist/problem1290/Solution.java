package com.github.demo.algorithm.leetcode.linkedlist.problem1290;

/**
 * 1290. 二进制链表转整数
 * @author Shawn
 * @date 2021/7/5
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode node = head;
        int res = 0;
        while(node != null) {
            res = (res<<1) +node.val;
            node = node.next;
        }
        return res;
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