package others.online.netease.test5;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 寻找NTES
 * @author Shawn
 * @date 2019/8/13
 */
public class Solution {

    @Test
    public void test() {
        int n = 4;
        String [] strs = {"ABNCDTEDDS","DDDEN","","DDDNTES"};
        String [] results = contains(n, strs);
        Arrays.stream(results).forEach(System.out::println);
    }

    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String [] strs = new String[n];
        for(int i = 0; i < n; i++) {
            strs[i] = in.nextLine();
        }
        String [] results = contains(n, strs);

        Arrays.stream(results).forEach(System.out::println);
    }*/

    private static String[] contains(int n, String[] strs) {
        String[] results = new String[n];
        if(n <=0 || null == strs || n != strs.length) {
            return results;
        }
        char [] mode = {'N', 'T', 'E', 'S'};
        for(int i = 0 ; i < strs.length; i++) {
            char [] chars = strs[i].toCharArray();
            int p = 0, q = 0;
            while (p < mode.length && q < chars.length) {
                if(mode[p] == chars[q]) {
                    p++;
                    q++;
                } else {
                    q++;
                }
            }
            if(p >= mode.length) {
                results[i] = "yes";
            } else {
                results[i] = "no";
            }
        }
        return results;
    }
}
