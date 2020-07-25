package leetcode.linklist.a_deleteNode;

/**
 * 剑指 Offer 18. 删除链表的节点 LCOF
 * 分析：单链表删除
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 * @author Shawn
 * @date 2020/7/25
 */
class Solution {
  public ListNode deleteNode(ListNode head, int val) {
    // 删除头节点
    if(head.val == val) return head.next;
    // 删除中间节点
    ListNode pre = head;
    ListNode p = head;
    while(p != null) {
      if(p.val == val) {
        pre.next = pre.next.next;
        return head;
      }
      pre = p;
      p = p.next;
    }
    return head;
  }
}
class ListNode{
  int val;
  ListNode next;
  ListNode(int x) { this.val = x; }
}
