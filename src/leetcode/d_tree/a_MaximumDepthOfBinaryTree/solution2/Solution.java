package leetcode.d_tree.a_MaximumDepthOfBinaryTree.solution2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. Maximum Depth of Binary Tree
 * 分析：
 * 广度优先遍历
 *
 * 时间复杂度：O(n)
 * 最坏空间复杂度：O(n)
 * @author Shawn
 * @date 2020/7/28
 */
class Solution {
  public int maxDepth(TreeNode root) {
    int depth = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    if(null == root) return 0;
    queue.add(root);
    while(!queue.isEmpty()) {
      int size = queue.size();
      while(size>0) {
        TreeNode tmp = queue.poll();
        if(null != tmp.left) queue.add(tmp.left);
        if(null != tmp.right) queue.add(tmp.right);
        size--;
      }
      depth++;
    }
    return depth;
  }
}
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { this.val = x; }
}
