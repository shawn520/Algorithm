package com.github.basic.archived.offer.online.netease.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Shawn
 * @date 2019/8/3
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 测试用例的组数
        int t = in.nextInt();
        if(t<1 || t>10) {
            return ;
        }
        List<int []> list = new ArrayList<>(t);
        for(int i = 0; i < t; i++) {
            int n = in.nextInt();
            if(n <3 || n > 1e5) {
                return ;
            }
            int [] array = new int[n];
            for(int j = 0; j < n; j++) {
                int num = in.nextInt();
                if(num >=1 && num <=1e9) {
                    array[j] = num;
                } else {
                    return ;
                }

            }
            list.add(array);
        }

        List<Boolean> result = get(list);
        for(Boolean res : result) {
            if(res) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    /*@Test
    public void test() {
        // 测试用例的组数
        int t = 1;
        List<int []> list = new ArrayList<>(t);
        for(int i = 0; i < t; i++) {
            int n = 5;
            int [] a_array = {17, 6, 17, 11, 17};
            list.add(a_array);
        }

        List<Boolean> result = get(list);
        for(Boolean res : result) {
            if(res) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }*/

    public static List<Boolean> get(List<int []> list) {
        int length = list.size();
        List<Boolean> result = new ArrayList<>(length);
        for(int[] array: list) {
            boolean res = circle(array);
            result.add(res);
        }
        return result;
    }

    public static boolean circle(int[] array) {
        if(array.length < 3) {
            return  false;
        }
        Arrays.sort(array);
        int length = array.length;
        for(int i=0; i< length; i++) {
            if(i == 0) {
                if(array[length-1] + array[i+1] <= array[i]) {
                    return false;
                }

            } else if(i == length - 1) {
                if(array[i-1] + array[0] <= array[i]) {
                    return false;
                }
            } else {
                if(array[i-1] + array[i+1] <= array[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
