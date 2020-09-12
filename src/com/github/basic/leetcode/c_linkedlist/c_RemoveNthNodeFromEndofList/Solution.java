package com.github.basic.leetcode.c_linkedlist.c_RemoveNthNodeFromEndofList;

/**
 * 19. Remove Nth Node From End of List
 * 分析：
 * 1. 统计链表的长度len
 * 2. 计算位置index
 * 3. 删除第index的位置
 * 时间复杂度O(2n)
 * 空间复杂度O(1)
 * @author Shawn
 * @date 2020/7/26
 */
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    int len = countLength(head);
    int index = len - n + 1;
    return delete(head, index);
  }

  public int countLength(ListNode head) {
    int len = 0;
    ListNode p = head;
    while(null != p) {
      len++;
      p = p.next;
    }
    return len;
  }

  public ListNode delete(ListNode head, int index) {
    if(index == 1) return head.next;
    ListNode pre = head;
    ListNode p = head.next;
    int i = 2;
    while(null != p) {
      if(i == index) {
        //delete node;
        pre.next = p.next;
        return head;
      }
      pre = p;
      p = p.next;
      i++;
    }
    return null;

  }
}

class ListNode{
  int val;
  ListNode next;
  ListNode(int x) { this.val = x; }
}


