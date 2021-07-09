package com.github.demo.algorithm.leetcode.linkedlist.problem83;

/**
 * 83. 删除排序链表中的重复元素
 *
 * 思路：逐个比较当前元素和下一个元素值是否相等，
 * 若相等，则删除当前元素的下一个元素
 * 若不相等，则当前指针指向下一个元素
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * @author Shawn
 * @date 2021/7/5
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
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