package com.github.demo.algorithm.leetcode.array.problem215.solution2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shawn
 * @date 2020/11/28
 */
public class SolutionTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    Solution solution;

    @Before
    public void init() {
        solution = new Solution();
    }

    @Test
    public void test1() {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int expected = 5;

        logger.info("input= {} \n k = {}", nums, k);
        int result = solution.findKthLargest(nums, k);
        logger.info("output: {}", result);
        logger.info("expected: {}", expected);
        Assert.assertEquals(result, expected);
        logger.info("Corrected");
    }

    @Test
    public void test2() {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int expected = 4;

        logger.info("input= {} \n k = {}", nums, k);
        int result = solution.findKthLargest(nums, k);
        logger.info("output: {}", result);
        logger.info("expected: {}", expected);
        Assert.assertEquals(result, expected);
        logger.info("Corrected");
    }


}
