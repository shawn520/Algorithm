package com.github.basic.leetcode.c_linkedlist.b_DeleteNodeInLinkedList;

/**
 * 237. Delete Node in a Linked List
 * 分析:只有一个参数，
 * 时间复杂度：O(1)
 * 空间复杂度:O(1)
 * @author Shawn
 * @date 2020/7/26
 */
class Solution {
  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
class ListNode{
  int val;
  ListNode next;
  ListNode(int x) { this.val = x; }
}
