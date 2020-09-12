package com.github.basic.archived.offer.group3.test32;

import org.junit.Test;

/**
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * @author Shawn
 * @date 2019/7/20
 */
public class Solution {

    @Test
    public void test() {
        // 功能测试
//        int n = 13;

        // 边界测试
//        int n = 1;

        // 负值测试
        int n = -1;

        int result = NumberOf1Between1AndN_Solution(n);
        System.out.println(result);

    }

    public int NumberOf1Between1AndN_Solution(int n) {
        StringBuilder builder = new StringBuilder();
        for(int i=1; i<=n; i++) {
            builder.append(i);
        }

        char [] chars = builder.toString().toCharArray();
        int count = 0;
        for(int i=0; i< chars.length; i++) {
            if(chars[i] == '1') {
                count++;
            }
        }
        return count;

    }
}
