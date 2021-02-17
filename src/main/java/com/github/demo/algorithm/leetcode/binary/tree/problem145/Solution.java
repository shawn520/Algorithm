package com.github.demo.algorithm.leetcode.binary.tree.problem145;

import java.util.ArrayList;
import java.util.List;


/**
 * 145. 二叉树的后续遍历
 *
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    void postorderTraversal(TreeNode node, List<Integer> res) {
        if(null == node) return;
        postorderTraversal(node.left, res);
        postorderTraversal(node.right, res);
        res.add(node.val);
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