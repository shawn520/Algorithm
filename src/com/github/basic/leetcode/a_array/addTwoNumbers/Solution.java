package com.github.basic.leetcode.a_array.addTwoNumbers;

/**
 * @author Shawn
 * @date 2020/6/27
 */
public class Solution {
//    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        ListNode p = l1;
//        p.next = new ListNode(4);
//        p.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        ListNode q = l2;
//        q.next = new ListNode(6);
//        q.next.next = new ListNode(4);
//
//        ListNode l3 = addTwoNumbers(l1, l2);
//        ListNode r = l3;
//        System.out.println("add result:");
//        while (r != null) {
//            System.out.println(r.val);
//            r = r.next;
//        }
//    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode r = l3;
        int flag = 0;
        int sum = 0;
        while(p != null || q != null || flag !=0 ) {
            if(p != null) {
                sum = sum + p.val;
                p = p.next;
            }
            if(q != null) {
                sum = sum + q.val;
                q = q.next;
            }
            sum += flag;
            if(sum >= 10) {
                sum -= 10;
                flag = 1;
            } else {
                flag = 0;
            }
            ListNode node = new ListNode(sum);
            r.next = node;
            r = r.next;
            sum = 0;
        }
        return l3.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode (int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
