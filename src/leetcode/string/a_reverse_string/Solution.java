package leetcode.string.a_reverse_string;

/**
 * 344. Reverse String
 * 思路：
 * 双指针
 * 时间复杂度： O(n)
 * 空间复杂度：O(1)
 * @author Shawn
 * @date 2020/7/22
 */
class Solution {
    public void reverseString(char[] s) {
        int i=0, j=s.length-1;
        while(i<j) {
            char tmp = s[i];
            s[i++] = s[j];
            s[j--] = tmp;
        }
    }

}
