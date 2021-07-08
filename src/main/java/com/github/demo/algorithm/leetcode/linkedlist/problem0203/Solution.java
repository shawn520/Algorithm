package com.github.demo.algorithm.leetcode.linkedlist.problem0203;

/**
 * 面试题 02.03. 删除中间节点
 *
 * 思路：将自己转化成下一个节点，再将自己删除
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
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}