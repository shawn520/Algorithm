package com.github.demo.algorithm.leetcode.linkedlist.problem237;

/**
 * 237. 删除链表中的节点
 * @author Shawn
 * @date 2021/7/5
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}


/** Definition for singly-linked list. */
class ListNode {
  int val;
  ListNode next;
  ListNode(int x ) {
      val = x;
  }
}