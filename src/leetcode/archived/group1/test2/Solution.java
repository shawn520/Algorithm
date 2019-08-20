package leetcode.archived.group1.test2;

/**
 * @author Shawn
 * @date 2019/7/12
 */

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, curr = head;

        int flag = 0;
        while(null != p || null !=q) {
            int x = (null == p) ? 0: p.val;
            int y = (null == q) ? 0: q.val;
            int sum = x + y + flag;
            flag = sum / 10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if(null != p) p = p.next;
            if(null != q) q = q.next;
        }
        if(flag > 0) {
            curr.next = new ListNode(flag);
        }
        return head.next;
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

        ListNode p = l1;
        while (null != p) {
            stack1.push(p.val);
            p = p.next;
        }

        ListNode q= l2;
        while (null != q) {
            stack2.push(q.val);
            q = q.next;
        }

        int flag = 0;
        int sum = 0;

        while (!stack1.isEmpty() && !stack2.isEmpty()) {

            sum = stack1.pop() + stack2.pop() + flag;
            if(sum >= 10) {
                flag = 1;
                sum = sum - 10;
            }else {
                flag = 0;
            }
            stack3.push(sum);
        }

        while (!stack1.isEmpty()) {
            sum = stack1.pop() + flag;
            if(sum >= 10) {
                flag = 1;
                sum = sum - 10;
            } else {
                flag = 0;
            }
            stack3.push(sum);
        }

        while (!stack2.isEmpty()) {
            sum = stack2.pop() + flag;
            if(sum >= 10) {
                flag = 1;
                sum = sum - 10;
            } else {
                flag = 0;
            }
            stack3.push(sum);
        }

        if(flag ==1) {
            stack3.push(flag);
        }

        ListNode result = null;
        if(!stack3.isEmpty()) {
            result = new ListNode(stack3.pop());
            p = result;
        }
        while (!stack3.isEmpty()) {
            ListNode node = new ListNode(stack3.pop());
            p.next = node;
            p = p.next;

        }

        return result;

    }


    /*public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode p = l1;
        while (null != p) {
            stack1.push(p.val);
            p = p.next;
        }

        ListNode q= l2;
        while (null != q) {
            stack2.push(q.val);
            q = q.next;
        }

        int flag = 0;

        int sum = stack1.pop() + stack2.pop();
        if(sum >= 10) {
            flag = 1;
            sum = sum - 10;
        }else {
            flag = 0;
        }

        ListNode result = new ListNode(sum);
        p = result;

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            sum = stack1.pop() + stack2.pop() + flag;
            if(sum >= 10) {
                flag = 1;
                sum = sum - 10;
            }else {
                flag = 0;
            }

            ListNode node = new ListNode(sum);
            p.next = node;
            p = p.next;

        }

        while (!stack1.isEmpty()) {
            sum = stack1.pop() + flag;
            flag = 0;
            ListNode node = new ListNode(sum);
            p.next = node;
            p = p.next;
        }

        while (!stack2.isEmpty()) {
            sum = stack2.pop() + flag;
            flag = 0;
            ListNode node = new ListNode(sum);
            p.next = node;
            p = p.next;
        }

        if(stack1.isEmpty() && stack2.isEmpty() && flag ==1) {
            ListNode node = new ListNode(flag);
            p.next = node;
            p = p.next;
        }

        return result;

    }*/
}
