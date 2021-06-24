package com.github.demo.algorithm.leetcode.array.problem119;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * @author Shawn
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for(int i=0; i<=rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                if(j==0 || j==i ) {
                    cur.add(1);
                } else {
                    int num = pre.get(j-1) + pre.get(j);
                    cur.add(num);
                }
            }
            pre = cur;
        }
        return pre;
    }
}
