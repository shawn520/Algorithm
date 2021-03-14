package com.github.demo.algorithm.leetcode.bit.problem405;

/**
 * 405. 数字转换为十六进制数
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * 思路：每4位做一次符号移位运算
 * @author Shawn
 */
class Solution {
    public String toHex(int num) {
        if(num == 0) return "0";
        String hex = "0123456789abcdef";
        String res = "";
        while(num!=0) {
            res = hex.charAt(num & 0xf) + res;
            num = num>>>4;
        }
        return res;
    }
}