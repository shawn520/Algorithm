package com.github.demo.algorithm.leetcode.linkedlist.problem141.solution2;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 *
 * 思路：hash
 * @author Shawn
 * @date 2021/7/5
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(null == head || null ==head.next ) return false;
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while(null != cur) {
            if(set.contains(cur)) return true;
            else set.add(cur);
            cur = cur.next;
        }
        return false;
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