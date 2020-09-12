package com.github.basic.archived.offer.group3.test35;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到
 * 第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）
 *
 * 思路：
 * 利用LinkedHashMap存储。key存储字符，value存储index
 * 利用LinkedHashSet存储，出现为一次的字符
 * 如果存在则删除LinkedHashSet中的元素
 * 如果不存在则在Map和set中均添加该元素。
 *
 * 然后取set中的第一个元素，去map中找index
 *
 * 时间复杂度为O(n), 且n的系数为1.
 * 空间复杂度为O(n)
 *
 * @author Shawn
 * @date 2019/7/22
 */
public class Solution {

    @Test
    public void test () {
        String str = "abcbabcbdabe";
        int result = FirstNotRepeatingChar(str);
        System.out.println(result);
    }

    public int FirstNotRepeatingChar(String str) {

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>(10000);
        LinkedHashSet<Character> queue = new LinkedHashSet<>(200);

        char [] chars = str.toCharArray();
        for(int i=0; i< chars.length; i++) {
            if(map.containsKey(chars[i])) {
                if(queue.contains(chars[i])) {
                    queue.remove(chars[i]);
                }
            } else {
                map.put(chars[i], i);
                queue.add(chars[i]);
            }
        }
        if(queue.size() >0) {
            Character character= queue.iterator().next();
            return map.get(character);
        }

        return -1;
    }
}
