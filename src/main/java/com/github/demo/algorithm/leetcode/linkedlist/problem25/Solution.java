package com.github.demo.algorithm.leetcode.linkedlist.problem25;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 *
 * 思路：指针
 * @author Shawn
 * @date 2021/7/5
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1) return l2;
        if(null == l2) return l1;
        ListNode head = null;
        if(l1.val <=l2.val) {
            head =l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode cur = head;
        while(l1 !=null && l2 != null) {
            if(l1.val <=l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next= l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2: l1;
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