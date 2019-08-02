package offer.group5.test52;

import org.junit.Test;

/**
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 *
 * 思路：
 * 匹配啊
 *
 * @author Shawn
 * @date 2019/7/31
 */
public class Solution {

    @Test
    public void test() {

        // 功能测试
        //char [] str = {'a', 'b', 'a', 'a'};
        //char [] pattern = {'a', 'b','*', 'a', 'c', '*', '.'};

        //char [] str = {'a', 'a', 'a'};
        //char [] pattern = {'a', 'b','*', 'a', 'c', '*', 'a'};

        //char [] str = {'a', 'a', 'a'};
        //char [] pattern = {'a', '.', 'a'};

        // 边界测试
        //char [] str = {};
        //char [] pattern = {',', '*'};

        char [] str = {};
        char [] pattern = {'.'};

        boolean result = match(str, pattern);
        System.out.println(result);

    }
    public boolean match(char[] str, char[] pattern) {

        if(null == str && null == pattern) {
            return true;
        }
        if(str.length ==0 && pattern.length ==1) {
            return false;
        }

        if(str.length <= 0 && (pattern.length <= 0 || (pattern.length ==2 && pattern[1] =='*'))) {
            return true;
        }

        int i = 0;
        int j = 0;
        while ( i < str.length || j < pattern.length) {
            if(str[i] == pattern[j]) {
                if(j+1 < pattern.length && pattern[j+1] == '*') {
                    i++;
                } else {
                    i++;
                    j++;
                }
            } else {
                if(pattern[j] == '.') {
                    i++;
                    j++;
                }else if(pattern[j+1] == '*') {
                    j = j + 2;
                    //i = i + 1;
                } else {
                    return false;
                }
            }
        }

        if(i >= str.length && j >= pattern.length) {
            return true;
        }

        return false;
    }
}
