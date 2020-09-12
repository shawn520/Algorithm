package com.github.basic.archived.offer.online.toutiao.test2;

import java.util.Scanner;

/**
 * @author Shawn
 * @date 2019/8/25
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long result = 0;
        if(n%2==0) {
             result = find(n/2);
        }
        System.out.println(result);
    }

    private static long find(int n) {
        if(n==0) return 1;
        if(n==1) return 1;
        long[] a = new long [n+1];
        a[0] = 1;
        a[1] = 1;
        for(int i=2; i<=n; i++) {
            a[i] = 0;
            for(int j=0; j<i;j++) {
                long c = a[j] % 1000000007;
                long b = a[i-j-1] % 1000000007;
                long temp = (c * b) % 1000000007;
                a[i] = (a[i] + temp) % 1000000007;
            }

        }
        return a[n];
    }
}
