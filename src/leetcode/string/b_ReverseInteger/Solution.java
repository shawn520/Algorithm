package leetcode.string.b_ReverseInteger;

/**
 * @author Shawn
 * @date 2020/7/22
 */
class Solution {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;
    }
}
