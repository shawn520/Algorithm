package com.github.basic.archived.offer.group6.test62;

import org.junit.Test;

/**
 * 序列化二叉树
 *
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 分析：
 * 先序遍历，如果遇到子树为空，则用$填充。
 *
 * 反序列化：如果遇到非$则增加node，然后扫描该node的左右子树。
 *
 * @author Shawn
 * @date 2019/8/12
 */
public class Solution {
    int index = -1;

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        String result = Serialize(node1);
//        String result = "12453674251637";
        TreeNode tree = Deserialize(result);

        System.out.println(result);
    }

    /**
     * 序列化二叉树
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        if(null == root) {
            builder.append("$,");
            return builder.toString();
        }
        builder.append(root.val + ",");
        builder.append(Serialize(root.left));
        builder.append(Serialize(root.right));
        return builder.toString();

    }


    /**
     * 反序列化二叉树
     * @param str
     * @return
     */
    TreeNode Deserialize(String str) {

        TreeNode node = null;
        index++;
        String [] strs = str.split(",");
        if(!strs[index].equals("$")) {
            node = new TreeNode(Integer.valueOf(strs[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }

        return node;
    }
}
