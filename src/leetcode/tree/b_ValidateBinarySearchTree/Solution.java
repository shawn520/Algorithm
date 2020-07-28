package leetcode.tree.b_ValidateBinarySearchTree;

/**
 * 98. Validate Binary Search Tree
 * 思路：
 * 递归
 * 左子树的值全部小于根节点的值，
 * 右子树的值全部大于根节点的值。
 * 时间复杂度：O(n)
 * 空间复杂度:O(n)
 * @author Shawn
 * @date 2020/7/29
 */
class Solution {
  public boolean isValidBST(TreeNode root) {
    return recurse(root, null, null);
  }
  public boolean recurse(TreeNode node, Integer lower, Integer upper) {
    if(null == node) return true;
    int val = node.val;
    if(null != lower && val <=lower) return false;
    if(null != upper && val >= upper) return false;
    if(!recurse(node.left, lower, val)) return false;
    if(!recurse(node.right, val, upper)) return false;
    return  true ;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { this.val = x; }
}
