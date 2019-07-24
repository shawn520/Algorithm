package offer.group1.test18;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
    this.val = val;

    }

}

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 思路：递归
 * @author Shawn
 * @date 2019/6/28
 */
public class Solution {
    public void Mirror(TreeNode root) {
        if(null != root) {
            if(null != root.left || null != root.right) {
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                if(null != root.left) {
                    Mirror(root.left);
                }
                if(null != root.right) {
                    Mirror(root.right);
                }
            }

        }
    }
}
