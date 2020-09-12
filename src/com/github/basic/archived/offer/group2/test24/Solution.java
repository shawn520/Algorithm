package com.github.basic.archived.offer.group2.test24;

import org.junit.Test;

/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @author Shawn
 * @date 2019/7/14
 */
public class Solution {

    @Test
    public void test() {

        // 功能测试
        //int [] sequence = {2, 4, 3, 8, 11, 9, 5};

        // 边界测试
        //int [] sequence = {};

        // 负面测试
        int [] sequence = {2, 4, 3, 8, 11, 1, 5};
        Boolean result = VerifySquenceOfBST(sequence);
        System.out.println(result);
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);

    }
    public boolean verify(int [] sequence, int left, int right ){
        if(left< right) {
            int data = sequence[right];
            int partition = right;
            for(int i = left; i < right; i++) {
                if(sequence[i] >= data) {
                    partition = i;
                    break;
                }
            }

            for(int i = partition; i<right; i++) {
                if(sequence[i] <= data) {
                    return false;
                }
            }

            Boolean leftResult = verify(sequence, left, partition-1);
            Boolean rightResult = verify(sequence, partition, right - 1);
            return leftResult && rightResult;

        } else {
            return true;
        }

    }

}
