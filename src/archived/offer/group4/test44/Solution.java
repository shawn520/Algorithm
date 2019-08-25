package archived.offer.group4.test44;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 *
 * 思路：借助队列先进先出的特点，每次左旋相当于先出队列，然后入队列操作。
 *
 *
 * @author Shawn
 * @date 2019/7/27
 */
public class Solution {

    @Test
    public void test() {

        // 功能测试
        String s = "abcXYZdef";
        int n = 3;
        String result = LeftRotateString(s, n);
        System.out.println(result);
    }

    public String LeftRotateString(String str,int n) {

        if(null == str || str.isEmpty()) {
            return str;
        }

        char [] chars = str.toCharArray();

        int length = chars.length;

        Queue<Character> queue = new ArrayDeque<>(length);
        for(int i = 0; i<length; i++) {
            queue.add(chars[i]);
        }

        Character temp;
        for(int j = 0; j < n; j++) {
            temp = queue.remove();
            queue.add(temp);
        }
        StringBuilder builder = new StringBuilder();
        for(Character cha : queue) {
            builder.append(cha);
        }
        return builder.toString();
    }
}
