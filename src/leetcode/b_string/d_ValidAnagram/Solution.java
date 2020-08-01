package leetcode.b_string.d_ValidAnagram;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 * 分析：
 * 使用map存储字符出现的次数
 *
 * 时间复杂度：O(2n)
 * 空间复杂度:O(1)
 * @author Shawn
 * @date 2020/7/23
 */
class Solution {
  public boolean isAnagram(String s, String t) {
    if(s.length() != t.length()) return false;
    Map<Character, Integer> map = new HashMap<>();
    for(int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      map.put(c, map.getOrDefault(c, 0) +1);
    }

    for(int i=0; i<t.length(); i++) {
      char c = t.charAt(i);
      if(!map.containsKey(c)) return false;
      else {
        int count = map.get(c);
        if(count == 0) {
          map.remove(c);
          return false;
        }
        map.put(c, --count);
      }
    }
    return true;
  }
}
