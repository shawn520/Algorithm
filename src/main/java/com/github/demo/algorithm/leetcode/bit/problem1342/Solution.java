package com.github.demo.algorithm.leetcode.bit.problem1342;

/**
 * 1342. 将数字变成 0 的操作次数
 *
 * 时间复杂度O(lg(n))
 * 空间复杂度O(1)
 *
 * 思路：根据题目写步骤
 * @author Shawn
 */
class Solution {
    public int numberOfSteps (int num) {
        int times = 0;
        while(num > 0) {
            if(num % 2 ==0) {
                num = num >>1;
            } else {
                num = num - 1;
            }
            times++;
        }
        return times;
    }
}