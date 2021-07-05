package com.github.demo.algorithm.leetcode.linkedlist.problem18.solution2;

/**
 * 剑指 Offer 18. 删除链表的节点
 *
 * 思路：单指针
 * @author Shawn
 * @date 2021/7/5
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(null == head) return null;
        if(head.val == val) return head.next;
        ListNode cur = head;
        while(cur.next !=null && cur.next.val != val) {
            cur = cur.next;
        }
        if(cur.next !=null) cur.next = cur.next.next;
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