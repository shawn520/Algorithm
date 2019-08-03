package others.online.netease.test4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Shawn
 * @date 2019/8/3
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // n 数字个数
        int n = in.nextInt();
        if(n<1) {
            return;
        }
        // q 操作个数
        int q = in.nextInt();
        if(q<1 || q > 200000) {
            return;
        }
        int [] a = new int[n];
        for(int i=0; i < n; i++) {
            int num = in.nextInt();
            if(num >= 1) {
                a[i] = num;
            } else {
                return;
            }
        }

        int [] query = new int[q];
        for(int j = 0; j < q; j++) {
            int num = in.nextInt();
            query[j] = num;
        }
        get(a, query);
    }

    private static void get(int[] a, int[] query) {
        int length = a.length;
        Arrays.sort(a);
        int times = query.length;
        for(int i=0; i < times; i++) {
            int num = query[i];
            int count = 0;
            int index = Arrays.binarySearch(a, num);
            if(index >= 0) {
                for(int j=index; j< length; j++) {
                    a[j]--;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
