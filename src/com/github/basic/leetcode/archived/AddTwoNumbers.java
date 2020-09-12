package com.github.basic.leetcode.archived;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class Solution {
   public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
    while(p.next != null || q.next != null){
    	int x = p.next.val;
    	int y = q.next.val;
    	int sum = carry + x + y;
    	carry = sum / 10;
    	curr.next = new ListNode(sum % 10);
    	curr = curr.next;
    	if(p!=null)
    		p = p.next;
    	if(q!=null)
    		q = q.next;
    } 
    if(carry>0)
    	curr.next =new ListNode(carry);
        return dummyHead.next;
  }  
}