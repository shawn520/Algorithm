package others.online.tencent.test3;

import java.util.Scanner;

/**
 * @author Shawn
 * @date 2019/9/1
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a= new int[n];
        for(int i=0; i<n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(n+1);
    }
}
