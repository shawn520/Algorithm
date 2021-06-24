package com.github.demo.algorithm.leetcode.array.problem118;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * @author Shawn
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                if(j==0 || j==i ) {
                    row.add(1);
                } else {
                    int num = res.get(i-1).get(j) + res.get(i-1).get(j-1);
                    row.add(num);
                }
            }
            res.add(row);
        }
        return res;
    }
}
