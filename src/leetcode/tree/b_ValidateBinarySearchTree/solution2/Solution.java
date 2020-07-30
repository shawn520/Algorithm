package leetcode.tree.b_ValidateBinarySearchTree.solution2;

/**
 * 98. Validate Binary Search Tree
 * 分析：
 * 中序遍历，判断当前节点值是否大于上一个节点的值
 *
 * 时间复杂度：O(n)
 * 空间复杂度:O(n)
 * @author Shawn
 * @date 2020/7/30
 */
class Solution {
  long pre = Long.MIN_VALUE;
  public boolean isValidBST(TreeNode root) {
    if(null == root) return true;
    if(!isValidBST(root.left)) return false;
    if(root.val <= pre) return false;
    pre = root.val;
    return isValidBST(root.right);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { this.val = x; }
}
