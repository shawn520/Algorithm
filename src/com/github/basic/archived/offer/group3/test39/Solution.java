package com.github.basic.archived.offer.group3.test39;

import org.junit.Test;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 *
 * @author Shawn
 * @date 2019/7/23
 */
public class Solution {

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        int depth = TreeDepth(node1);
        System.out.println(depth);

    }

    public int TreeDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }

        int max = 0;
        int depth = 0;
        return findDepth(root, depth, max);
    }

    private int findDepth(TreeNode root,int depth, int max) {
        TreeNode p = root;
        if(p !=null) {
            depth++;
            if(max < depth) {
                max = depth;
            }
        } else {
            return max;
        }
        int left = findDepth(p.left, depth, max);
        int right = findDepth(p.right, depth, max);
        max = Math.max(left, right);
        return max;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
