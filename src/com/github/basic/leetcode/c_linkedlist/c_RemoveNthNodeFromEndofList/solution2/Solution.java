package com.github.basic.leetcode.c_linkedlist.c_RemoveNthNodeFromEndofList.solution2;

/**
 * 19. Remove Nth Node From End of List
 * 分析：
 * 双指针
 * 时间复杂度：O(n)
 * 空间复杂度:O(1)
 * @author Shawn
 * @date 2020/7/26
 */
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode preHead = new ListNode(0);
    preHead.next = head;
    ListNode start = preHead, end = preHead;
    int i=0;
    while(i<=n) {
      start = start.next;
      i++;
    }
    while(start!=null) {
      start = start.next;
      end = end.next;
    }
    end.next =end.next.next;
    return preHead.next;
  }
}

class ListNode{
  int val;
  ListNode next;
  ListNode(int x) { this.val = x; }
}
