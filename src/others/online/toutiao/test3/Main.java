package others.online.toutiao.test3;

import java.util.Scanner;

/**
 * @author Shawn
 * @date 2019/8/25
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [][] a = new int[4][4];
        int [][] result = find(n, a);
        for(int i=0; i<4; i++) {
            for(int j=0; j<4;j++) {
                System.out.print(result[i][j] +' ');
            }
            System.out.println();
        }
    }

    private static int[][] find(int n, int[][] a) {
        return a;
    }
}
