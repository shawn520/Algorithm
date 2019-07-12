package offer.group3.test23;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 分析：借助队列的数据结构实现分层遍历二叉树
 *
 * @author Shawn
 * @date 2019/7/10
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();

        TreeNode q = root;

        Queue<TreeNode> queue = new ArrayDeque<>();
        if(null != q) {
            queue.add(q);
        }

        while (!queue.isEmpty()){
            TreeNode tree = queue.remove();
            result.add(tree.val);
            if(null != tree.left) {
                queue.add(tree.left);
            }
            if(null != tree.right) {
                queue.add(tree.right);
            }
        }
        return result;

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
