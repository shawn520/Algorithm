package com.github.basic.leetcode.f_dp;

import org.junit.Test;

/**
 * 动态规划，爬梯子问题
 * @author Shawn
 * @date 2019/7/9
 */
public class ClimbingStairs {

    @Test
    public void test() {

        // 测试用例：功能测试
        int result = climbStairs(10);

        // 测试用例: 边界测试
        //int result = climbStairs(2);

        // 测试用例：负面测试
        //int result = climbStairs(-1);

        System.out.println(result);
    }

    /*public int climbStairs(int n) {
        if(0 == n) {
            return 0;
        } else if(1 == n) {
            return 1;
        } else if(2 == n) {
            return 2;
        }

        return climbStairs(n-1) + climbStairs(n-2);

    }*/

    public int climbStairs(int n) {
        if(0 >= n) {
            return 0;
        } else if(1 == n) {
            return 1;
        } else if(2 == n) {
            return 2;
        }

        int a = 1;
        int b = 2;
        for(int i = 3; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
