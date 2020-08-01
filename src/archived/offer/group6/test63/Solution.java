package archived.offer.group6.test63;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的第k个结点
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，
 * 按结点数值大小顺序第三小结点的值为4。
 *
 * 分析：
 * 二叉搜索树，中序遍历有序。
 * 注意k的取值范围，（1，d_tree.size())
 * @author Shawn
 * @date 2019/8/12
 */
public class Solution {

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        TreeNode node = KthNode(node1, 100);
        System.out.println(node.val);
    }

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(null == pRoot || k < 1) {
            return null;
        }

        List<TreeNode> list = inOrder(pRoot);

        if(k > list.size()) {
            return null;
        }
        return list.get(k-1);
    }

    private List<TreeNode> inOrder(TreeNode pRoot) {

        if(null == pRoot) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        if(null != pRoot.left) {
            list.addAll(inOrder(pRoot.left));
        }
        list.add(pRoot);
        if(null!= pRoot.right) {
            list.addAll(inOrder(pRoot.right));
        }
        return list;

    }


}
