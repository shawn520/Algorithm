package com.github.demo.algorithm.leetcode.array.problem125;

/**
 * 125. 验证回文串
 *
 * @author Shawn
 * @date 2020/11/30
 */
class Solution {
    public boolean isPalindrome(String s) {
        if(null == s || s.length() == 0) return true;
        int len = s.length();
        int i = 0;
        int j = len - 1;
        while(i<j) {
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
