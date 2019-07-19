package offer.group3.test28;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的
 * 所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 思路：
 *   分解
 * @author Shawn
 * @date 2019/7/19
 */
public class Solution {

    @Test
    public void test() {
        // 功能测试
        String input = "abc";
        ArrayList<String> arrayList = Permutation(input);
        arrayList.stream().forEach(System.out:: println);
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList = new ArrayList<>();

        // LinkedHashSet保证元素有序，且去重
        LinkedHashSet<String> set = new LinkedHashSet<>();
        if(null == str || str.isEmpty()) {
            return arrayList;
        }

        char [] chars = str.toCharArray();
        int index = 0;
        Permutation(set, chars, index);
        for (String string : set) {
            arrayList.add(string);
        }
        // 字典序排序
        Collections.sort(arrayList);
        return arrayList;
    }

    private void Permutation(LinkedHashSet<String> set, char[] chars, int begin) {

        if(begin == chars.length -1) {
            set.add(String.valueOf(chars));
        } else {
            for(int i = begin; i< chars.length; i++) {
                swap(chars, i, begin);
                Permutation(set, chars, begin + 1);
                swap(chars, i, begin);
            }
        }
    }

    private void swap(char[] chars, int index, int i) {
        char t = chars[index];
        chars[index] = chars[i];
        chars[i] = t;
    }

}
