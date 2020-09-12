package com.github.basic.archived.offer.online.huawei.test1;

/**
 * @author Shawn
 * @date 2019/7/31
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Double D = in.nextDouble();
        sell(D);
        //System.out.println(D);
    }

    /*@Test
    public void test() {
        Double D = 3.14159265358979;
        int N = sell(D);
        int M = (int)(Math.ceil(D * N));
        System.out.println();
    }*/

    public static int sell(Double D) {
        double abs = 1;
        int N = 0;
        int M = 0;
        for(int i=113; i<= 10000; i++) {
            int m = (int)(D * i);
            double r = 1.0 * m /i;
            if(Math.abs(r-D) < abs) {
                abs = Math.abs(r-D);
                N = i;
                M  = m ;
            }
            int G = m-1;
            r = 1.0 * m /i;
            if(Math.abs(r-D) < abs) {
                abs = Math.abs(r-D);
                N = i;
                M = G;
            }

            int C = m+1;
            r = 1.0 * m /i;
            if(Math.abs(r-D) < abs) {
                abs = Math.abs(r-D);
                N = i;
                M = C;
            }

        }

        System.out.println(M + " " + N);
        return N;

    }
}
