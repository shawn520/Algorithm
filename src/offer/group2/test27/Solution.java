package offer.group2.test27;

import org.junit.Test;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 首先，举个例子，构造一颗二叉搜索树，用例子帮助找思路。
 *
 * 分析： 二叉搜索树转换成有序双向链表，首先想到中序遍历。
 *
 * 将问题分解成子问题，递归解决。
 *
 * 根节点的左指针，指向左子树，根节点的右指针指向右子树。
 *
 * 然后再从根节点往左找head指针指向头节点。
 *
 * @author Shawn
 * @date 2019/7/18
 */
public class Solution {

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(50);
        TreeNode node2 = new TreeNode(40);
        TreeNode node3 = new TreeNode(60);
        TreeNode node4 = new TreeNode(35);
        TreeNode node5 = new TreeNode(45);
        TreeNode node6 = new TreeNode(55);
        TreeNode node7 = new TreeNode(65);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        TreeNode head = Convert(node1);
        System.out.println(head);

    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(null == pRootOfTree) {
            return null;
        }
        //TreeNode p = pRootOfTree;

        // 二叉搜索树转换成有序双向链表
        TreeNode result = reverse(pRootOfTree);

        // 找到head节点
        TreeNode p = result;
        TreeNode q = result;
        while (null != q) {
            p = q;
            q = q.left;
        }
        TreeNode head = p;

        return head;

    }

    private TreeNode reverse(TreeNode pRootOfTree) {

        if(null == pRootOfTree.left && null == pRootOfTree) {
            return pRootOfTree;
        }

        // 根节点左指针指向左子树最大节点
        if(null != pRootOfTree.left) {
            TreeNode left = reverse(pRootOfTree.left);

            TreeNode p = left;
            TreeNode q = left;

            while (p != null) {
                q = p;
                p = p.right;
            }
            q.right = pRootOfTree;
            pRootOfTree.left = q;
        }

        // 跟节点右指针指向右子树最小节点
        if(null != pRootOfTree.right) {
            TreeNode right = reverse(pRootOfTree.right);
            TreeNode p = right;
            TreeNode q = right;
            while (p != null) {
                q = p;
                p = p.left;
            }
            q.left = pRootOfTree;
            pRootOfTree.right = q;
        }
        return pRootOfTree;

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

