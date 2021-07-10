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
        ListNode ob = head;
        while(ob != null) {
            ListNode oc = ob;
            while(oc.next != null) {
                if(oc.next.val == ob.val) {
                    oc.next = oc.next.next;
                } else {
                    oc = oc.next;
                }
            }
            ob = ob.next;
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