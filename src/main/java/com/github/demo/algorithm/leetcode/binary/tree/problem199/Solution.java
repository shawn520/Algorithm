package com.github.demo.algorithm.leetcode.binary.tree.problem199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 199. 二叉树的右视图
 *
 * 思路：二叉树层次遍历，取每层最后一个元素放入数组中
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * @author Shawn
 * @date 2021/2/17
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if(null == root) return result;
        queue1.add(root);
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            if(!queue1.isEmpty()) {
                test(queue1, queue2, result);
            } else {
                test(queue2, queue1, result);
            }
        }
        return result;
    }

    public void test(Queue<TreeNode> queue1, Queue<TreeNode> queue2, List<Integer> result) {
        TreeNode rightest = null;
        while(!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            rightest = node;
            if(node.left != null) queue2.add(node.left);
            if(node.right != null) queue2.add(node.right);
        }
        result.add(rightest.val);
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