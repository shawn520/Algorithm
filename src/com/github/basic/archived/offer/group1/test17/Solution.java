package com.github.basic.archived.offer.group1.test17;




class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
    this.val = val;

    }

}

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构。
 * 思路：分两步走，首先找跟B树根节点相同的节点。然后判断是否包含。
 * 二次递归。
 * @author Shawn
 * @date 2019/6/28
 */
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        Boolean result = false;

        if(null != root1 && null != root2) {
            if(root1.val == root2.val) {
               result = DoesTreeContainsTree2(root1, root2);
            }

            if(!result) {
                result = HasSubtree(root1.left, root2);
            }
            if(!result) {
                result = HasSubtree(root1.right, root2);
            }

        }

        return result;
    }

    private Boolean DoesTreeContainsTree2(TreeNode root1, TreeNode root2) {
        if(null == root2) {
            return  true;
        }
        if(null == root1) {
            return  false;
        }
        if(root1.val != root2.val) {
            return false;
        }

        return DoesTreeContainsTree2(root1.left, root2.left) &&
                DoesTreeContainsTree2(root1.right, root2.right);
    }

}
