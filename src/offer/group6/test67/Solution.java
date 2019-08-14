package offer.group6.test67;

import org.junit.Test;

/**
 *
 * 机器人的运动范围
 * 题目描述
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 * 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * 分析：
 * 回溯法
 *
 *
 * @author Shawn
 * @date 2019/8/14
 */
public class Solution {
    /*@Test
    public void test() {
        int threshold = 5;
        int rows = 10;
        int cols = 10;
        int count = movingCount(5, 10, 10);
        System.out.println(count);
    }*/

    public int movingCount(int threshold, int rows, int cols)
    {
        if(rows < 1 || cols < 1 || threshold < 0) {
            return 0;
        }

        int row = 0;
        int col = 0;
        boolean [] visited = new boolean[rows*cols];
        for(int i = 0 ; i < rows * cols; i++) {
            visited[i] = false;
        }
        int count = move(threshold, rows, cols, visited, row, col, 0);
        return count;

    }

    private int move(int threshold, int rows, int cols, boolean[] visited, int row, int col, int count) {

        if(row>=0 && row< rows && col>=0 && col<cols &&!visited[row*cols + col]) {
            int sum = 0;
            int i = row;
            int j = col;
            while (i != 0) {
                sum += i % 10;
                i = i / 10;
            }
            while (j != 0) {
                sum += j % 10;
                j = j / 10;
            }
            visited[row*cols + col] = true;
            if(sum <= threshold) {
                count++;
                count = move(threshold, rows, cols, visited, row-1, col, count);
                count = move(threshold, rows, cols, visited, row+1, col, count);
                count = move(threshold, rows, cols, visited, row, col-1, count);
                count = move(threshold, rows, cols, visited, row, col+1, count);
            }

        }
        return count;
    }

}
