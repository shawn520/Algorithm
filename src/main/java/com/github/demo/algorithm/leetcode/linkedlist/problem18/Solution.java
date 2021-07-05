package com.github.demo.algorithm.leetcode.linkedlist.problem18;

/**
 * 剑指 Offer 18. 删除链表的节点
 *
 * 思路：双指针
 * @author Shawn
 * @date 2021/7/5
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(null == head) return null;
        if(head.val == val) return head.next;
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null) {
            if(cur.val == val) {
                prev.next = cur.next;
                break;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        return head;
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