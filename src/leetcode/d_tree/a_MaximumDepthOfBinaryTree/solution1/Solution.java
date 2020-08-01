package leetcode.d_tree.a_MaximumDepthOfBinaryTree.solution1;

/**
 * 104. Maximum Depth of Binary Tree
 * 分析：
 * 使用递归的方式
 * 如果节点为空则返回0
 * 如果节点不为空，则返回左右子树最大高度+1
 *
 * 时间复杂度：O(n)
 * 空间复杂度:O(height)
 * @author Shawn
 * @date 2020/7/28
 */
class Solution {
  public int maxDepth(TreeNode root) {
    if(null == root) return 0;
    if(null == root.left && null ==root.right) return 1;
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { this.val = x; }
}

