package leetcode.string.c_FirstUniqueCharacterInString;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 * 分析：
 * 用map存储字符出现的次数
 * 时间复杂度：O(2n)
 * 空间复杂度: O(1.35n)
 * @author Shawn
 * @date 2020/7/23
 */
class Solution {
  public static final Integer LEN = 26;
  public int firstUniqChar(String s) {
    Map<Character, Integer> map = new HashMap<>(LEN);
    // count the times
    for(int i=0; i<s.length(); i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    // find the index
    for(int i=0; i<s.length(); i++) {
      if(map.get(s.charAt(i)) == 1) return i;
    }
    return -1;
  }
}
