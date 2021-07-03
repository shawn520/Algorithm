package com.github.demo.algorithm.leetcode.binary.tree.problem199.solution2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 199. 二叉树的右视图
 *
 * 思路：广度优先搜索
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(null == root) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if(null != node.left) queue.add(node.left);
                if(null != node.right) queue.add(node.right);
                if( i== size-1) result.add(node.val);
            }
        }
        return result;
    }

}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}