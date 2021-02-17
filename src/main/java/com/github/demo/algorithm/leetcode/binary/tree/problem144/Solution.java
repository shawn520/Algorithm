package com.github.demo.algorithm.leetcode.binary.tree.problem144;

import java.util.ArrayList;
import java.util.List;


/**
 * 144. 二叉树的前序遍历
 *
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;

    }
    void preorderTraversal(TreeNode node, List<Integer> res) {
        if(null == node) {
            return;
        }
        res.add(node.val);
        preorderTraversal(node.left, res);
        preorderTraversal(node.right, res);
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