package archived.offer.group5.test50;

import org.junit.Test;

/**
 * 题目描述
 * 将一个字符串转换成一个整数(实现Integer.valueOf(b_string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 *
 * 思路：
 * 遍历String，charAt(i) 如果大于9或小于0return0；
 * 乘以10
 *
 *
 * @author Shawn
 * @date 2019/7/31
 */
public class Solution {

    @Test
    public void test() {
        String s = "+123";
        int result = StrToInt(s);
        System.out.println(result);

        int result2 = Integer.valueOf(s);
        System.out.println(result2);
    }

    public int StrToInt(String str) {
        int length = str.length();
        if(null == str || str.isEmpty()) {
            return 0;
        }
        boolean flag = false;
        int sum = 0;
        if(str.charAt(0) =='-') {
            flag = true;
        } else if(str.charAt(0) =='+') {
//            flag = false;

        } else if(str.charAt(0)>'0' && str.charAt(0) <'9') {
            sum = 10 * sum + (str.charAt(0) - '0');
        } else {
            return 0;
        }


        for(int i = 1; i < length; i++) {
            char data = str.charAt(i);
            if(data>'9' || data <'0') {
                return 0;
            }
            sum = 10 * sum + (data - '0');

        }

        if(flag) {
            sum = -sum;
        }

        return sum;

    }
}
