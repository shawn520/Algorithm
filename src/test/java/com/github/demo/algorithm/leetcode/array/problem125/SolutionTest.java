package com.github.demo.algorithm.leetcode.array.problem125;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Shawn
 * @date 2020/11/30
 */
public class SolutionTest {
    Solution solution;

    @Before
    public void init() {
        solution = new Solution();
    }

    @Test
    public void test1() {
        String input = "A man, a plan, a canal: Panama";
        boolean res = solution.isPalindrome(input);

        boolean expected = true;
        Assert.assertEquals(res, expected);

    }

    @Test
    public void test2() {
        String input = "race a car";
        boolean res = solution.isPalindrome(input);

        boolean expected = false;
        Assert.assertEquals(res, expected);

    }

    @Test
    public void test3() {
        String input = "";
        boolean res = solution.isPalindrome(input);

        boolean expected = true;
        Assert.assertEquals(res, expected);

    }
}
