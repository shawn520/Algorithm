package com.github.demo.algorithm.leetcode.binary.tree.problem144.solution2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * 144. 二叉树的前序遍历
 * 迭代
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if(null == root) return res;
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);

            if(null != cur.right) {
                stack.push(cur.right);
            }
            if(null != cur.left) {
                stack.push(cur.left);
            }
        }
        return res;
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