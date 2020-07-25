package leetcode.string.e_ValidPalindrome;

/**
 * 125. Valid Palindrome
 *
 * 分析：双指针
 * 时间复杂度:O(n), n为字符串的长度
 * 空间复杂度：O(1)
 * @author Shawn
 * @date 2020/7/25
 */
class Solution {
  public static boolean isPalindrome(String s) {
    int len = s.length();
    int i=0, j=len-1;
    while (i<j) {
      while (i<j && !Character.isLetterOrDigit(s.charAt(i))) {
        i++;
      }
      while (i<j && !Character.isLetterOrDigit(s.charAt(j))) {
        j--;
      }
      if(i<j) {
        if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
          return false;
        }
        i++;
        j--;
      }
    }
    return true;
  }
}

