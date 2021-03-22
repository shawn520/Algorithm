package com.github.demo.algorithm.leetcode.bit.problem1290;

/**
 * 1290. 二进制链表转整数
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * 思路：模拟移位
 * @author Shawn
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        ListNode node = head;
        while(node != null) {
            res = (res<<1) + node.val;
            node = node.next;
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}