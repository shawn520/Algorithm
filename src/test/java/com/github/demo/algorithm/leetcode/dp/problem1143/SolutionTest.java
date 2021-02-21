package com.github.demo.algorithm.leetcode.dp.problem1143;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Shawn
 * @date 2021/2/19
 */
public class SolutionTest {
    Solution solution = new Solution();


    @Test
    public void test() {
        String str1 = "abcde";
        String str2 = "ace";
        int res = solution.longestCommonSubsequence(str1, str2);
        Assert.assertEquals(res, 3);

    }
}
