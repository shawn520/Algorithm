package com.github.basic.archived.offer.group6.test66;

/**
 * 矩阵中的路径
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，
 * 向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，
 * 则之后不能再次进入这个格子。 例如 a b c e s f c s a d e e 这样
 * 的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 *
 * 分析：
 *
 *
 * @author Shawn
 * @date 2019/8/13
 */
public class Solution {

    /*@Test
    public void test() {
        char[] matrix = {'a', 'b', 'c', 'e','s', 'f', 'c', 's','a', 'd', 'e', 'e'};
        int rows = 3;
        int cols = 4;
        char [] str = {'b', 'c', 'c', 'e', 'd'};
        boolean result = hasPath(matrix, rows, cols, str);
        System.out.println(result);

    }*/

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        // 边界校验
        if(null == matrix || null == str) {
            return false;
        }
        int length = matrix.length;
        if(str.length == 0 || length ==0 || length != rows * cols) {
            return false;
        }

        char [][] mat = new char[rows][cols];
        boolean [][] flag = new boolean[rows][cols];


        int k= 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                mat[i][j] = matrix[k++];
                flag[i][j] = true;
            }
        }

        for(int i = 0 ; i < matrix.length; i++ ) {
            if(matrix[i] == str[0]) {
                int row = i / cols;
                int col = i % cols;
                boolean res = contains(mat, flag, rows, cols, str, row, col, 0);
                if(res) {
                    return true;
                }
            }
        }

        return false;

    }

    private boolean contains(char[][] mat, boolean[][] visited, int rows, int cols, char[] str, int i, int j, int k) {
        boolean flag = false;
        if(k < str.length && i>=0 && i< rows && j>=0 && j< cols) {
            if(visited[i][j] && (mat[i][j] == str[k])) {
                k++;
                if(k == str.length) {
                    return true;
                }
                visited[i][j] = false;
                flag = contains(mat, visited, rows, cols, str, i-1, j, k) ||
                        contains(mat, visited, rows, cols, str, i+1, j, k) ||
                        contains(mat, visited, rows, cols, str, i, j-1, k) ||
                        contains(mat, visited, rows, cols, str, i, j+1, k);
                if(!flag) {
                    k--;
                    visited[i][j] = true;
                }
            }

        }
        return flag;

    }

}
