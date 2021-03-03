package com.github.demo.algorithm.leetcode.dp;

/**
 * 0-1背包问题
 *
 * 时间复杂度O(mn)
 * 空间复杂度O(mn)
 *
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {

    public static void main(String[] args) {
        int[] w = {1, 4, 3};    //物品重量   w[i]
        int[] p = {1500, 3000, 2000};   //物品价格 p[i]
        int m = 4; //背包容量
        int n = p.length; //物品个数

        //创建一个二维数组，表示
        //v[i][j] 表示在前i个物品中能够装入容量为j的背包的最大价值
        int[][] c = new int[n+1][m+1];

        //初始化第一行和第一列，这里在本程序中，可以不去处理，因为默认就是0
        for(int i=0; i <c[0].length; i++) {
            c[0][i] = 0;    //将第一行设置为0
        }

        for(int j=0; j<c.length; j++) {
            c[j][0] = 0;    //将第一列设置为0
        }

        //根据前面的公式来进行动态规划处理
        for(int i=1; i<c.length; i++) { //不处理第一行
            for(int j=1; j<c[0].length; j++) { //不处理第一列
                if(j-w[i-1] <0) {
                    c[i][j] = c[i-1][j];
                } else {
                    c[i][j] = Math.max(c[i-1][j], p[i-1] + c[i-1][j-w[i-1]]);
                }

            }
        }

        //输出，看结果
        for(int i=0; i<c.length; i++) {
            for(int j=0; j<c[0].length; j++) {
                System.out.print(c[i][j] + "\t");
            }
            System.out.println();
        }




    }

}
