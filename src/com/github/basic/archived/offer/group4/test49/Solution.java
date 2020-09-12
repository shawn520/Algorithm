package com.github.basic.archived.offer.group4.test49;

import org.junit.Test;

/**
 * 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 思路：不能用加减乘除，则考虑用位运算模拟两数求和。
 *
 * @author Shawn
 * @date 2019/7/31
 */
public class Solution {

    @Test
    public void test() {
        int num1 = 30;
        int num2 = 22;
        int result = Add(num1, num2);
        System.out.println(result);
    }

    public int Add(int num1,int num2) {

        while (0 != num2) {
            int sum = num1^num2;
            int carry = (num1&num2)<<1;
            num1 = sum;
            num2 = carry;
        }
        return num1;

    }
}
