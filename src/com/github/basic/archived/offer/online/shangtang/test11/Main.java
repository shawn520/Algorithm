package com.github.basic.archived.offer.online.shangtang.test11;

/**
 * @author Shawn
 * @date 2019/8/19
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int [] a = new int[N];
        int [] b = new int[N];
        int [] c = new int[N];
        for(int i = 0; i < N; i++) {
            a[i] = in.nextInt();
        }
        for(int i = 0; i < N; i++) {
            b[i] = in.nextInt();
        }
        for(int i = 0; i < N; i++) {
            c[i] = in.nextInt();
        }

        int result = code(a,b,c);
        System.out.println(result);
    }

    private static int code(int[] a, int[] b, int[] c) {
        int N = a.length;
        int max = 0;
        int index = 0;
        int sum = 0;
        for(int i=0; i<N; i++) {
            int start = a[i];
            index = i;
            sum = start;
            for(int j = 0; j != index && j <N; j++) {
                sum += b[j];
            }
            if(sum > max) {
                max = sum;
            }
        }

        return sum;

    }

}
