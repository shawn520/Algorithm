package offer.group3.test25;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * 思路：二叉树前序遍历，用一个list存储路径。
 * @author Shawn
 * @date 2019/7/15
 */
public class Solution {

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        ArrayList<ArrayList<Integer>> paths = FindPath(node1, 22);
        System.out.println(paths);

    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        int sum = 0;
        if(null != root) {
            findPath(root, target, sum, path, paths);
        }
        return paths;
    }

    public void findPath(TreeNode root, int target, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> paths) {

        if(null != root) {
            sum += root.val;
            path.add(root.val);
            if(null == root.left && null == root.right) {
                if(sum == target) {
                    paths.add(new ArrayList<>(path));

                }
                path.remove(path.size()-1);
            } else {
                if(null != root.left) {
                    findPath(root.left, target, sum, path, paths);

                }
                if(null != root.right) {
                    findPath(root.right, target, sum, path, paths);
                }
                path.remove(path.size()-1);

            }

        }
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
