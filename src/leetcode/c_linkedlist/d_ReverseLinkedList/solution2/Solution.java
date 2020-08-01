package leetcode.c_linkedlist.d_ReverseLinkedList.solution2;

/**
 * 206. Reverse Linked List
 * 分析：递归
 * 重点理解：head.next.next =head;
 * 结束递归条件：head == null || head.next ==null
 * 避免成环：head.next = null;
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * @author Shawn
 * @date 2020/7/26
 */
class Solution {
  public ListNode reverseList(ListNode head) {
    if(head == null || head.next ==null) {
      return head;
    }
    ListNode cur = reverseList(head.next);
    head.next.next =head;
    head.next = null;
    return cur;
  }
}
class ListNode{
  int val;
  ListNode next;
  ListNode(int x) { this.val = x; }
}
