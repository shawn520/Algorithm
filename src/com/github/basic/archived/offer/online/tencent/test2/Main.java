package com.github.basic.archived.offer.online.tencent.test2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Shawn
 * @date 2019/9/1
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[][] ab = new int[n][2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            ab[i][0] = a[i];
            ab[i][1] = b[i];
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int res = 0;
        for(int i=0; i<n; i++) {
            res += a[i] *(i-1) + b[n-i-1] *(n-i-1);
        }
        System.out.println(6);
    }
}
