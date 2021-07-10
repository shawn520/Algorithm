package com.github.demo.algorithm.leetcode.linkedlist.problem160.solution3;

/**
 * 160. 相交链表
 *
 * 思路：双指针
 *
 * 时间复杂度：O(m+n)
 * 空间复杂度:O(n)
 * @author Shawn
 * @date 2021/7/5
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
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