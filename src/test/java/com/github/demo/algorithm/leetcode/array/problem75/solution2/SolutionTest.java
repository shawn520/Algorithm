package com.github.demo.algorithm.leetcode.array.problem75.solution2;

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
        int[] nums = {2,0,2,1,1,0};
        int[] expected = {0,0,1,1,2,2};

        logger.info("input: {}", nums);
        solution.sortColors(nums);
        logger.info("output: {}", nums);
        logger.info("output: {}", expected);
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != expected[i]) {
                logger.info("Wrong");
                Assert.fail();
                return ;
            }
        }
        logger.info("Corrected");
    }

    @Test
    public void test2() {
        int[] nums = {2,0,1};
        int[] expected = {0,1,2};

        logger.info("input: {}", nums);
        solution.sortColors(nums);
        logger.info("output: {}", nums);
        logger.info("output: {}", expected);
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != expected[i]) {
                logger.info("Wrong");
                Assert.fail();
                return ;
            }
        }
        logger.info("Corrected");
    }

    @Test
    public void test3() {
        int[] nums = {0};
        int[] expected = {0};

        logger.info("input: {}", nums);
        solution.sortColors(nums);
        logger.info("output: {}", nums);
        logger.info("output: {}", expected);
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != expected[i]) {
                logger.info("Wrong");
                Assert.fail();
                return ;
            }
        }
        logger.info("Corrected");
    }
}
