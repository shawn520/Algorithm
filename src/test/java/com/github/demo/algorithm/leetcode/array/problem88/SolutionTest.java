package com.github.demo.algorithm.leetcode.array.problem88;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Shawn
 * @date 2020/11/29
 */
public class SolutionTest {
    Solution solution;

    @Before
    public void init() {
        solution = new Solution();
    }

    @Test
    public void test1() {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        solution.merge(nums1, m, nums2, n);

        int[] expected = {1,2,2,3,5,6};
        Assert.assertArrayEquals(nums1, expected);

    }

    @Test
    public void test2() {
        int[] nums1 = {0};
        int[] nums2 = {1};
        int m = 0;
        int n = 1;
        solution.merge(nums1, m, nums2, n);

        int[] expected = {1};
        Assert.assertArrayEquals(nums1, expected);

    }
}
