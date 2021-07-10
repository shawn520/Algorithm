package com.github.demo.algorithm.leetcode.linkedlist.problem234;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 *
 * 思路：转数组，用双指针
 *
 * 时间复杂度：O(n)
 * 空间复杂度:O(n)
 * @author Shawn
 * @date 2021/7/5
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int size = list.size();
        int i=0, j=0;
        if(size %2 ==0) {
            i = size/2-1;
            j = size/2;
        } else {
            i = size/2;
            j = size/2;
        }
        while(i>=0 && j<size) {
            if(list.get(i) != list.get(j)) {
                return false;
            }
            i--;
            j++;
        }
        return true;
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