package leetcode.a_array.easy.l_ContainsDuplicate.solution3;

import java.util.HashSet;
import java.util.Set;

/**
 * 使用HashSet
 *
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 * @author Shawn
 * @date 2020/7/19
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for(int num: nums) {
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
