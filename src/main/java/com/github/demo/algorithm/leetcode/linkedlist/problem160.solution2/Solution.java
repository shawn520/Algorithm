package com.github.demo.algorithm.leetcode.linkedlist.problem160.solution2;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. 相交链表
 *
 * 思路：hash集合
 *
 * 时间复杂度：O(m+n)
 * 空间复杂度:O(n)
 * @author Shawn
 * @date 2021/7/5
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        Set<ListNode> visited = new HashSet<>();
        while(pa != null) {
            visited.add(pa);
            pa = pa.next;
        }
        while(pb != null) {
            if(visited.contains(pb)) {
                return pb;
            }
            pb = pb.next;
        }
        return null;
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