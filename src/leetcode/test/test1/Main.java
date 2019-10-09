package leetcode.test.test1;

import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        // 构造矩阵
        int [][] a = new int[n][m];
        int [] b = new int[n*m];
        int p = 0;
        for(int i=0;i<n;i++) {
            for(int j=0; j<m; j++) {
                a[i][j] = (i+1) * (j+1);
                b[p++] = a[i][j];
            }
        }

        Arrays.sort(b);
        // 寻找第k大的值
        System.out.println(b[n*m-k]);
    }
}
