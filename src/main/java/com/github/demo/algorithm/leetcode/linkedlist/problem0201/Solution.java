package com.github.demo.algorithm.leetcode.linkedlist.problem0201;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.01. 移除重复节点
 *
 * 思路：hash集合
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * @author Shawn
 * @date 2021/7/5
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> visited = new HashSet<>();
        if(null == head) return null;
        visited.add(head.val);
        ListNode cur = head;
        while(cur.next!=null) {
            if(visited.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                visited.add(cur.next.val);
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