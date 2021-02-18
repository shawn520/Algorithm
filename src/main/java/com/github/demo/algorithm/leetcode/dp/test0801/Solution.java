package com.github.demo.algorithm.leetcode.dp.test0801;

/**
 * 面试题 08.01. 三步问题
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public int waysToStep(int n) {
        int f1 = 1;
        int f2 = 2;
        int f3 = 4;
        int f4 = f3 + f2 + f1;
        if(n==1) return f1;
        if(n==2) return f2;
        if(n==3) return f3;
        for(int i=4; i<=n; i++) {
            f4 = (f3 + f2)%1000000007;
            f4 = (f4 + f1)%1000000007;
            f1 = f2%1000000007;
            f2 =f3%1000000007;
            f3 = f4%1000000007;
        }
        return f4;
    }
}