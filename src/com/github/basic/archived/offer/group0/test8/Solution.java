package com.github.basic.archived.offer.group0.test8;

/**
 * 题目描述:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Solution {
    public int JumpFloor(int target) {
        if(target <=0){
            return -1;
        }
        if(1 == target) {
            return 1;
        }else if (2 == target) {
            return 2;
        }else {
            return JumpFloor(target-1) + JumpFloor(target-2);
        }

    }
}