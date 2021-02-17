package com.github.demo.algorithm.leetcode.array.problem46;

import org.junit.Test;

import java.util.List;

/**
 * @author Shawn
 * @date 2021/2/16
 */
public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test() {
        int [] nums = {1,2,3};
        List<List<Integer>> res = solution.permute(nums);
        System.out.println(res.toArray());
    }
}
