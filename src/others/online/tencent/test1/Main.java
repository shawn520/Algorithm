package others.online.tencent.test1;

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
        int evenA=0;
        int evenB = 0;
        int [] a = new int[n];
        int [] b = new int[m];
        for(int i=0; i<n; i++) {
            a[i] = in.nextInt();
            if(a[i] % 2 ==0) evenA++;
        }
        for(int j=0; j<m; j++) {
            b[j] = in.nextInt();
            if(b[j] % 2 ==0) evenB++;
        }
        int result = Math.min(evenA, m-evenB) + Math.min(n-evenA, evenB);
        System.out.println(result);

    }
}
