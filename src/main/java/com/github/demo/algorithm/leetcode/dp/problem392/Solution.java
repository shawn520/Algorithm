package com.github.demo.algorithm.leetcode.dp.problem392;

/**
 * 392. 判断子序列
 *
 * 时间复杂度O(m+n)
 * 空间复杂度O(1)
 *
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while( i< s.length() && j<t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}