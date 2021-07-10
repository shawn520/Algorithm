package com.github.demo.algorithm.leetcode.linkedlist.problem0201.solution2;

/**
 * 面试题 02.01. 移除重复节点
 *
 * 思路：双层循环
 *
 * 时间复杂度：O(n2)
 * 空间复杂度：O(1)
 * @author Shawn
 * @date 2021/7/5
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if(null == head) return null;
        ListNode p1 = null;
        ListNode pre = null;
        ListNode p2 = null;
        for(p1=head; p1!=null; p1=p1.next) {
            pre = p1;
            p2 = p1.next;
            while(p2!= null) {
                if(p1.val == p2.val) {
                    pre.next = p2.next;
                } else {
                    pre = pre.next;
                }
                p2 = p2.next;
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