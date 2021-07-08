package com.github.demo.algorithm.leetcode.linkedlist.problem876;

/**
 * 876. 链表的中间结点
 *
 * 思路：快慢指针
 * @author Shawn
 * @date 2021/7/5
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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