package com.github.basic.archived.offer.online.huawei.test2;

import java.util.Scanner;

/**
 * @author Shawn
 * @date 2019/7/31
 */
public class Main {

    /*@Test
    public void test () {
        String a1 = "AABCD";
        String a2 = "CDAA";
        String b1 = "AABCD";
        String b2 = "ABCD";
        String c1 = "AABCD";
        String c2 = "CFS";
        contain(a1, a2, b1, b2, c1, c2);
        System.out.println();

    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a1 = sc.nextLine();
        String a2 = sc.nextLine();
        String b1 = sc.nextLine();
        String b2 = sc.nextLine();
        String c1 = sc.nextLine();
        String c2 = sc.nextLine();
        contain(a1, a2, b1, b2, c1, c2);
        //System.out.println();
    }

    public static void contain(String a1, String a2,
                               String b1, String b2,
                               String c1, String c2) {
        if(a1.isEmpty()) {
            System.out.print(0);
        } else {
            a1 = a1 + a1;
            if(a1.contains(a2)) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        }

        if(b1.isEmpty()) {
            System.out.print(0);
        } else {
            b1 = b1 + b1;
            if(b1.contains(b2)) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        }

        if(c1.isEmpty()) {
            System.out.print(0);
        } else {
            c1 = c1 + c1;
            if(c1.contains(c2)) {
                System.out.print(1);
            } else {
                System.out.print(0);
            }

        }

    }
}
