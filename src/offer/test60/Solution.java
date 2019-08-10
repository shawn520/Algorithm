package offer.test60;

import org.junit.Test;


import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 按之字形顺序打印二叉树
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 * 层序遍历二叉树
 *
 * 解决思路：
 * 通过两个栈来实现，分别保存奇数层和偶数层。
 *
 * 如果两个栈有一个不为空：
 * 奇数层栈odd如果不为空，出栈。
 * 如果该节点存在左孩子，左孩子入oven栈；
 * 如果该节点存在右孩子，右孩子入overn栈。
 * 循环直至odd为空
 *
 * 偶数层栈oven如果不为空，出栈。
 * 如果该节点右孩子不为空，右孩子入odd栈。
 * 如果该节点左孩子不为空，左孩子入odd栈。
 * 循环直至oven为空
 *
 * 循环直至odd和oven为空，结束。
 *
 * @author Shawn
 * @date 2019/8/7
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

    /**
     * 层序遍历二叉树
     * @param p
     */
    public void layerOrder(TreeNode p) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(null != p) {
            queue.add(p);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.println(node.val);
            if(null != node.left) {
                queue.add(node.left);
            }
            if(null != node.right) {
                queue.add(node.right);
            }

        }
    }

    /**
     * 按之字形打印二叉树
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Stack<TreeNode> odd = new Stack<>();
        Stack<TreeNode> oven = new Stack<>();
        if (null != pRoot) {
            odd.push(pRoot);
        }
        while (!odd.isEmpty() || !oven.isEmpty()) {
            if(!odd.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!odd.isEmpty()) {
                    TreeNode node = odd.pop();
                    list.add(node.val);
                    if (null != node.left) {
                        oven.push(node.left);
                    }
                    if (null != node.right) {
                        oven.push(node.right);
                    }
                }
                result.add(list);
            }

            if(!oven.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!oven.isEmpty()) {
                    TreeNode node = oven.pop();
                    list.add(node.val);
                    if (null != node.right) {
                        odd.push(node.right);
                    }
                    if (null != node.left) {
                        odd.push(node.left);
                    }
                }
                result.add(list);
            }

        }
        return result;
    }
}


