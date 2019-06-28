package offer.group2.test17;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构。
 * @author Shawn
 * @date 2019/6/28
 */


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
    this.val = val;

    }

}
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        Boolean result = false;

        // 约定空树不是任意一个树的子结构
        if(null == root1 || null == root2) {
            return false;
        }

        if(root1.val ==root2.val) {
            if(null == root1.left && null == root1.right &&
                    null == root2.left && null == root2.right) {
                result = true;
            } else if(null != root1.left && null == root1.right &&
                    null != root2.left && null == root2.right) {
                Boolean left = HasSubtree(root1.left, root2.left);
                if(left) {
                    result = true;
                }

            } else if(null == root1.left && null != root1.right &&
                    null == root2.left && null != root2.right) {
                Boolean right = HasSubtree(root1.right, root2.right);
                if(right) {
                    result = true;
                }

            } else {
                Boolean left = HasSubtree(root1.left, root2.left);
                Boolean right = HasSubtree(root1.right, root2.right);
                if(left && right) {
                    result = true;
                }
            }
        } else {
            // 递归查询左子树是否包含root2
            Boolean leftHasSubtree = HasSubtree(root1.left, root2);
            if(leftHasSubtree) {
                result = true;
            } else {
                // 递归查询右子树是否包含root2
                Boolean rightHasSubtree = HasSubtree(root1.right, root2);
                if(rightHasSubtree) {
                    result = true;
                }
            }

        }

        return result;

    }

}
