package leetcode.array.easy.l_ContainsDuplicate.solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * 分析：
 * 用一个map来存元素
 * 遍历数组：
 * 如果map中存在该元素，则返回true
 * 否则返回true
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * @author Shawn
 * @date 2020/7/19
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) return true;
            else map.put(nums[i], i);
        }
        return false;
    }
}
