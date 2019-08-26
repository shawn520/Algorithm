package others.online.alibaba.test3;

import java.util.Scanner;

/**
 * 最少删除字符
 *
 * 思路：
 * 两个指针分别指向字符串的首尾字符，向中间扫扫描。
 * @author Shawn
 * @date 2019/8/25
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] chars = str.toCharArray();
        char[] result = min(chars, 0, chars.length-1);
    }

    private static char[] min(char[] chars, int i, int j) {
        char[] result = new char[chars.length];
        int k = 0;
        while (i<j) {
            if(chars[i] == chars[j]) {
                i++;
                j--;
                result[k++] = chars[i];
            } else {
                min(chars, --i, j);
                min(chars, i, --j);
            }
        }
        return result;
    }
}
