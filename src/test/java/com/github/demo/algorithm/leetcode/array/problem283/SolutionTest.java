package com.github.demo.algorithm.leetcode.array.problem283;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Shawn
 * @date 2021/2/15
 */
public class SolutionTest {
    Solution solution;

    @Before
    public void init() {
        solution = new Solution();
    }

    @Test
    public void test1() {
        int[] input = {0,1,0,3,12};
        int[] output = {1,3,12,0,0};
        solution.moveZeroes(input);
        Assert.assertArrayEquals(input, output);
    }
}
