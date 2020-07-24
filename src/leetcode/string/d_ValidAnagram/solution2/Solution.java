package leetcode.string.d_ValidAnagram.solution2;

/**
 * 242. Valid Anagram
 * 分析：
 * 使用一个数组表示a-z字母出现的频率
 *
 * 时间复杂度：O(n)
 * 空间复杂度:O(1)
 * @author Shawn
 * @date 2020/7/24
 */
class Solution {
  public boolean isAnagram(String s, String t) {
    if(s.length() != t.length())    return false;
    int [] counter = new int[26];
    for(int i=0; i<s.length(); i++) {
      counter[s.charAt(i) - 'a']++;
      counter[t.charAt(i) - 'a']--;
    }
    for(int count: counter) {
      if(count != 0) return false;
    }
    return true;
  }
}
