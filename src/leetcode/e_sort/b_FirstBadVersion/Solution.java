package leetcode.e_sort.b_FirstBadVersion;

/**
 * 278. First Bad Version
 * 分析：二分查找
 * left = 1, right = n
 * 计算mid = left + (right-left)/2
 * 如果isBadVersion(mid) =true, 则right = mid
 * 如果mid是false, 则left = mid +1
 *
 *
 * 时间复杂度：O(lgn)
 * 空间复杂度: O(1)
 * @author Shawn
 * @date 2020/8/1
 */
public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    int left = 1;
    int right = n;
    while(left<right) {
      int mid = left+(right-left)/2;
      if(isBadVersion(mid)) {
        right = mid;
      } else {
        left = mid+1;
      }
    }
    return left;
  }

}
