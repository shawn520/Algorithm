package com.github.basic.archived.offer.group4.test45;

import org.junit.Test;


/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * 分析：将句子按照空格分隔，
 * 然后用i，j分别指向数组的left和right
 * while i<j,则交换i,j索引上的值，i++,j--
 *
 * @author Shawn
 * @date 2019/7/27
 */
public class Solution {

    @Test
    public void test() {
        // 功能测试
//        String str = "student. a am I";

        // 边界测试
//        String str ="";
        String str =" ";
        String result = ReverseSentence(str);
        System.out.println(result);
    }

    public String ReverseSentence(String str) {

        if(null == str || str.isEmpty()) {
            return str;
        }

        String [] strings = str.split(" ");
        if(strings.length == 0) {
            return str;
        }
        int length = strings.length;
        int i = 0;
        int j = length - 1;
        while (i < j) {
            swap(strings, i, j);
            i++;
            j--;
        }
        StringBuilder builder = new StringBuilder();
        for(String s: strings) {
            builder.append(s);
            builder.append(" ");
        }

        builder.deleteCharAt(builder.length() -1);

        return builder.toString();

    }

    private void swap(String[] strings, int i, int j) {
        String temp = strings[i];
        strings[i] = strings[j];
        strings[j] = temp;
    }
}
