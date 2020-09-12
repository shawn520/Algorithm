package com.github.basic.archived.offer.online.alibaba.test1;

import org.junit.Test;

import java.util.*;

/**
 * 补齐区间
 * 思路：
 * 用两个变量min, max分别记录最大值，最小值。
 * 用map存储区间的值。
 *
 * 遍历min,和max之间的所有不包含的区间。
 *
 *
 * @author Shawn
 * @date 2019/8/25
 */
public class Main {

    @Test
    public void test() {
        int [][] input1 = {{2,3}, {1,4}, {8,9}};
        List<List<Integer>> results1 = get(input1);
        System.out.println("test1 =" + results1.toString());

        int [][] input2 = {{8,9},{2,3},{1,4}, {6,9}};
        List<List<Integer>> results2 = get(input2);
        System.out.println("test2 =" + results2.toString());

        int [][] input3 = {{1,4},{12,14},{2,5}, {8,9}};
        List<List<Integer>> results3 = get(input3);
        System.out.println("test3 =" + results3.toString());

        int [][] input4 = {{1,4},{2,5},{9,12}, {6,8}};
        List<List<Integer>> results4 = get(input4);
        System.out.println("test4 =" + results4.toString());

        int [][] input5 = {{17, 19},{9, 11},{1, 4}, {10, 13}, {19, 20}, {3, 6}};
        List<List<Integer>> results5 = get(input5);
        System.out.println("test5 =" + results5.toString());


    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // n 为输入的区间个数
        int n = in.nextInt();
        int [][] a = new int[n][2];
        for(int i=0; i<n; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
        }
        List<List<Integer>> results = get(a);

        for(List<Integer> result: results) {
            System.out.println(result.toString());
        }
    }

    private static List<List<Integer>> get(int[][] a) {

        int n = a.length;
        List<List<Integer>> result = new ArrayList();
        // init
        int min = a[0][0];
        int max = a[0][1];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            int p = a[i][0];
            min = Math.min(p, min);
            int q = a[i][1];
            max = Math.max(q, max);
            for(int j = p; j<=q;j++) {
                map.put(j, 1);
            }
        }

        for(int i=min; i<max; i++) {
            if(!map.containsKey(i)) {
                List<Integer> list = new ArrayList<>(2);
                list.add(0, i);
                list.add(1, i);
                for(int j=i+1; j<max; j++) {
                    if(!map.containsKey(j)) {
                        list.set(1, j);
                        map.put(j, 1);
                    }
                }
                result.add(list);
            }
        }
        return result;
    }
}
