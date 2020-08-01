package leetcode.a_array.easy.o_IntersectionofTwoArraysII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 思路：
 * 用map遍历数组一，并存放数组一中元素出现的次数。
 * 遍历数组二，如果元素出现的次数大于等于1，则次数减一，将该元素加入输出数组。
 *
 * 时间复杂度：O(m+n)
 * 空间复杂度:O(m+n)
 * @author Shawn
 * @date 2020/7/19
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums1.length;i++) {
            int key = nums1[i];
            if(map.containsKey(key)) {
                int value = map.get(key);
                map.put(key, ++value);
            } else {
                map.put(key, 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums2.length; i++) {
            int key = nums2[i];
            if(map.containsKey(key)) {
                int value = map.get(key);
                if(value >=1) {
                    list.add(key);
                    map.put(key, --value);
                }
            }
        }
        int[] array = new int[list.size()];
        int i=0;
        for(int x : list) {
            array[i] = list.get(i);
            i++;
        }
        return array;
    }
}
