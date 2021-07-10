package com.github.demo.algorithm.leetcode.linkedlist.problem203;

/**
 * 203. 移除链表元素
 *
 * 思路：区分头节点和中间节点
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * @author Shawn
 * @date 2021/7/5
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(null != head && head.val ==val) {
            head = head.next;
        }
        if(null == head) return null;
        ListNode cur = head;
        while(cur.next != null) {
            if(cur.next.val ==val) {
                cur.next = cur.next.next;
            } else {
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