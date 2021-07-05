package com.github.demo.algorithm.leetcode.linkedlist.problem21;

/**
 * 21. 合并两个有序链表
 *
 * 思路：指针
 * @author Shawn
 * @date 2021/7/5
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1) return l2;
        if(null == l2) return l1;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = null;
        if(p1.val <=p2.val) {
            head = p1;
            p1 = p1.next;
        } else {
            head = p2;
            p2 = p2.next;
        }
        ListNode cur = head;
        while(p1 != null && p2 != null) {
            if(p1.val <=p2.val) {
                cur.next = p1;
                cur = cur.next;
                p1 = p1.next;
            } else {
                cur.next = p2;
                cur = cur.next;
                p2 = p2.next;
            }
        }
        if(p1 != null) cur.next = p1;
        if(p2 != null) cur.next = p2;
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