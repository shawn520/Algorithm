package com.github.demo.algorithm.leetcode.array.problem414;

import java.util.Arrays;

/**
 * @author Shawn
 * @date 2021/6/24
 */
public class SolutionTest {
    public static void main(String[] args) {
        new Solution();
        int[] nums = {2, 2, 3, 1};
        int[] array = Arrays.stream(nums).distinct().sorted().toArray();
        System.out.println(array);


    }
}
