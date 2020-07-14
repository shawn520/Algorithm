package leetcode.array.easy.f_PlusOne;

/**
 * 分析：
 * 从后往前遍历数组：
 * 如果非9，则加1返回
 * 如果为9，则变为0，继续遍历
 * 如果全是9，则重新申请新的数组，长度加1，首位置1
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * @author Shawn
 * @date 2020/7/15
 */
class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1; i>=0; i--) {
            if(digits[i] !=9) {
                // first non-9 will be incremented by 1 and then return the result
                digits[i] +=1;
                return digits;
            }
            // if it is 9, make it zero
            digits[i] = 0;
        }
        // if we reached here means we have a case where the array consists of all nine
        // In that case, the array is all zeroes, we just need to make 0th position 1.
        int [] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }
}
