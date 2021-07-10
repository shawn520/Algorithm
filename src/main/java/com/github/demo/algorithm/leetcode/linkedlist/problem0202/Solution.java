package com.github.demo.algorithm.leetcode.linkedlist.problem0202;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 *
 * 思路：双指针
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * @author Shawn
 * @date 2021/7/5
 */
class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode left = head, right = head;
        while(--k >0) right = right.next;
        while(right.next != null) {
            right = right.next;
            left = left.next;
        }
        return left.val;

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