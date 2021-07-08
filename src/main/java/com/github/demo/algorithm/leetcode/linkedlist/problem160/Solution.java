package com.github.demo.algorithm.leetcode.linkedlist.problem160;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. 相交链表
 *
 * 思路：hash集合
 * @author Shawn
 * @date 2021/7/5
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> setA = new HashSet<>();
        Set<ListNode> setB = new HashSet<>();
        ListNode pa = headA;
        ListNode pb = headB;
        while(pa != null) {
            setA.add(pa);
            pa = pa.next;
        }
        while(pb != null) {
            if(setA.contains(pb)) {
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