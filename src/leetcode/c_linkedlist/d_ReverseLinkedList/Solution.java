package leetcode.c_linkedlist.d_ReverseLinkedList;

/**
 * 206. Reverse Linked List
 * 分析：双指针
 * 每次反转一个指针
 * 时间复杂度：O(n)
 * 空间复杂度O(1)
 * @author Shawn
 * @date 2020/7/26
 */
class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode cur = null;
    ListNode pre = head;
    while(pre !=null) {
      ListNode t = pre.next;
      pre.next = cur;
      cur = pre;
      pre = t;
    }
    return cur;
  }
}
class ListNode{
  int val;
  ListNode next;
  ListNode(int x) { this.val = x; }
}
