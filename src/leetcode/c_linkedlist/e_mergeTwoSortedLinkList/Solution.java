package leetcode.c_linkedlist.e_mergeTwoSortedLinkList;

/**
 * 合并两个有序链表
 * 分析：伪头节点 + 双指针
 *
 * 时间复杂度：O(m+n)
 * 空间复杂度: O(1)
 * @author Shawn
 * @date 2020/7/26
 */
class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dum = new ListNode(0);
    ListNode cur =dum;
    while(l1!=null && l2!=null) {
      if(l1.val <=l2.val) {
        cur.next = l1;
        cur = cur.next;
        l1 = l1.next;
      } else {
        cur.next = l2;
        cur = cur.next;
        l2 = l2.next;
      }
    }
    if(l1 != null) {
      cur.next = l1;
    }
    if(l2 != null) {
      cur.next = l2;
    }
    return dum.next;
  }
}
class ListNode{
  int val;
  ListNode next;
  ListNode(int x) { this.val = x; }
}
