package com.github.demo.algorithm.leetcode.array.problem118;

import java.util.List;

/**
 * @author Shawn
 * @date 2021/6/24
 */
public class SolutionTest {

    public static void main(String[] args) {
        List<List<Integer>> generate = new Solution().generate(5);
        System.out.println(generate.toString());
    }
}
