package com.github.basic.archived.offer.group5.test55;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，
 * 第一个只出现一次的字符是"l"。
 *
 * 输出描述：
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * @author Shawn
 * @date 2019/8/3
 */
public class Solution {
    LinkedHashSet<Character> set = new LinkedHashSet<>();
    HashSet<Character> hashSet = new HashSet<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(hashSet.contains(ch)) {
            if(set.contains(ch)) {
                set.remove(ch);
            }
        } else {
            hashSet.add(ch);
            set.add(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        if(!set.isEmpty()) {
            return set.iterator().next();
        }
        return '#';
    }
}
