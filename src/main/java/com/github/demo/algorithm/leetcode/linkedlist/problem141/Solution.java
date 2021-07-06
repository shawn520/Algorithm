package com.github.demo.algorithm.leetcode.linkedlist.problem141;

/**
 * 141. 环形链表
 *
 * 思路：快慢指针
 * @author Shawn
 * @date 2021/7/5
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(null == head || null ==head.next ) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast) {
            if(fast ==null || fast.next ==null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
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