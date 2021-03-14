package com.github.demo.algorithm.leetcode.bit.problem389;

/**
 * 389. 找不同
 *
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * 思路：异或运算
 * @author Shawn
 */
class Solution {
    public char findTheDifference(String s, String t) {
        int res = 0;
        int n = s.length();
        for(int i=0; i<n; i++) {
            res= res^s.charAt(i)^t.charAt(i);
        }
        res=res^t.charAt(n);
        return (char)res;
    }
}