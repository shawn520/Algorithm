package com.github.basic.archived.offer.group6.test61;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 把二叉树打印成多行
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * 思路：
 * 借助队列的特性。同时用一个变量保存每一层的个数。
 *
 *
 * @author Shawn
 * @date 2019/8/10
 */
public class Solution {
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
        ArrayList<ArrayList<Integer>> results = Print(node1);
        results.stream().forEach(System.out::println);
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(null != pRoot) {
            queue.add(pRoot);
        }
        int num = queue.size();
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            list.add(node.val);
            if(null != node.left) {
                queue.add(node.left);
            }
            if(null != node.right) {
                queue.add(node.right);
            }
            num--;
            if(num == 0) {
                num = queue.size();
                results.add(list);
                list = new ArrayList<>();

            }
        }
        return results;

    }
}
