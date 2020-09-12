package com.github.basic.archived.offer.online.shangtang.test1;

/**
 * @author Shawn
 * @date 2019/8/19
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] A = new int[n];
        for(int i=0; i<n; i++) {
            A[i] = in.nextInt();
        }
        int m = in.nextInt();
        int [] B = new int[m];
        for(int i=0; i<m; i++) {
            B[i] = in.nextInt();
        }
        int [] x = new int[n];
        for(int i=0; i<n; i++) {
            x[i] = in.nextInt();
        }

        int [] result = new int [x.length -1];

        for(int i = 0; i< x.length; i++) {
            result[i] = x[i] + x[i+1];
        }

        for(int i=0; i<result.length; i++) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}