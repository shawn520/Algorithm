package offer.group5.test59;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 对称的二叉树
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，
 * 定义其为对称的。
 *
 * 分析：
 * 可以使用先序遍历和对称的先序遍历。
 * 如果两者序列相同，则为对称二叉树。否则否。
 *
 *
 * @author Shawn
 * @date 2019/8/6
 */
public class Solution {

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        boolean result = isSymmetrical(node1);
        System.out.println(result);

    }
    boolean isSymmetrical(TreeNode pRoot) {
        if(null == pRoot) {
            return true;
        }
        List<Integer> pre = new ArrayList<>();
        List<Integer> synPre = new ArrayList<>();
        pre = preOrder(pre, pRoot);
        synPre = symPreOrder(synPre, pRoot);
        for(int i=0; i < pre.size(); i++) {
            if(!pre.get(i).equals(synPre.get(i))) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> symPreOrder(List<Integer> pre, TreeNode pRoot) {
        if(null == pRoot) {
            pre.add(-1);
            return pre;
        }
        pre.add(pRoot.val);
        pre.addAll(symPreOrder(pre, pRoot.right));
        pre.addAll(symPreOrder(pre, pRoot.left));
        return pre;
    }

    private List<Integer> preOrder(List<Integer> pre, TreeNode pRoot) {

        if(null == pRoot) {
            pre.add(-1);
            return pre;
        }
        pre.add(pRoot.val);
        pre.addAll(preOrder(pre, pRoot.left));
        pre.addAll(preOrder(pre, pRoot.right));
        return pre;
    }
}
