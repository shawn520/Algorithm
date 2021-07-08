package com.github.demo.algorithm.leetcode.array.problem414;

/**
 * TODO 414. 第三大的数
 * @author Shawn
 */
class Solution {
    public int thirdMax(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thridMax = Integer.MIN_VALUE;
        //不使用long或者Integer的话使用标志位判断数组中是否真实存在最小值
        boolean hasMin = false;
        for (int num : nums) {
            if (num == Integer.MIN_VALUE) hasMin = true;
            if (num > firstMax) {
                thridMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (num < firstMax && num > secondMax) {
                thridMax = secondMax;
                secondMax = num;
            } else if (num < secondMax && num > thridMax){
                thridMax = num;
            }
        }
        // 如果第三大不是最小值，则返回真实最小值
        if (thridMax != Integer.MIN_VALUE) return thridMax;
        // 到这里第三大是最小值，需要判断这个最小值是不是真实存在
        // 如果第二大还是最小值，表示无论最小值是不是真的第二大，第三大都不可能是真实最小值
        // 如果第二大不是最小值，这个时候就要看数组中是否真实存在最小值了
        if (secondMax == Integer.MIN_VALUE || !hasMin) return firstMax;
        // 数组中真实存在最小值，且为第三大
        return thridMax;
    }
}

