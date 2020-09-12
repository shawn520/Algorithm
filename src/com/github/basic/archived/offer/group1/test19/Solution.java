package com.github.basic.archived.offer.group1.test19;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 *
 * @author Shawn
 * @date 2019/7/17
 */
public class Solution {

    @Test
    public void test() {
        // 功能测试
//        int [][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        // 边界测试：只有一个元素
//        int [][] matrix = {{1}};

        // 边界测试：只有一行
//        int [][] matrix = {{1,2,3,4}};
        // 边界测试：只有一列
//        int [][] matrix = {{1},{2},{3},{4},{5}};
        // 边界测试：只有一行一列
        int [][] matrix = {{1,2,3,4}, {5,6,7,8}};

        ArrayList<Integer> list = printMatrix(matrix);

        System.out.println(list);
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix.length == 0) {
            return null;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;

        int start = 0;
        ArrayList<Integer> result = new ArrayList<>(rows * columns);
        while (columns > 2 * start && rows > 2 * start) {
            ArrayList<Integer> array = printCircle(matrix, rows, columns, start);
            result.addAll(array);
            start ++;

        }
        return result;

    }

    private ArrayList<Integer> printCircle(int[][] matrix, int rows, int columns, int start) {

        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        ArrayList<Integer> result = new ArrayList<>();
        // 从左到右打印第一行
        for(int j = start; j <= endX; j++) {
            result.add(matrix[start][j]);
        }

        // 从上到下打印
        if(start < endY) {
            for(int i = start + 1; i<= endY; i++ ) {
                result.add(matrix[i][endX]);
            }
        }

        // 从右到左打印
        if(start < endX && start < endY) {
            for(int i = endX-1; i>=start; i--) {
                result.add(matrix[endY][i]);
            }
        }

        // 从下到上打印
        if((start + 2 <= endY) && (start < endX)) {
            for(int i = endY -1; i>start; i--) {
                result.add(matrix[i][start]);
            }
        }

        return result;

    }
}
