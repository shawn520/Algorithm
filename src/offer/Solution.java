package offer;

import org.junit.Test;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @author Shawn
 * @date 2019/7/24
 */
public class Solution {

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        //TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        //node3.right = node6;
        node5.left = node7;
        Boolean result = IsBalanced_Solution(node1);
        System.out.println(result);

    }

    public boolean IsBalanced_Solution(TreeNode root) {

        // 空树也是平衡二叉树
        if(null == root) {
            return true;
        }
        // 非空从1开始计算深度
        int depth = 1;

        TreeNode p = root;
        // 左子树高度
        double left = findDepth(p.left, depth);
        // 右子树高度
        double right = findDepth(p, depth);

        // 如果左右子树有一个不平衡，返回false
        if(left == -1 || right == -1) {
            return false;
        }

        // 判断当前树是否是平衡二叉树
        if(Math.abs(left - right) <=1) {
            return true;
        }

        return false;

    }

    public double findDepth(TreeNode root,int depth) {
        TreeNode p = root;
        if(p !=null) {
            depth++;
        } else {
            return depth;
        }
        // 递归判断左右子树是不是平衡二叉树
        double left = findDepth(p.left, depth);
        double right = findDepth(p.right, depth);
        if(left == -1 || right == -1) {
            return -1;
        }

        if(Math.abs(left - right) <=1) {
            return Math.max(left, right);
        }
        return -1;

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
