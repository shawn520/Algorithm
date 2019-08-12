package offer.group0.test4;

import org.junit.Test;

import java.util.HashMap;

/**
 * 重建二叉树
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 *
 * 分析：
 * 根据例子，按照前序遍历和中序遍历构造二叉树的规则写代码
 *
 * @author Shawn
 * @date 2019/8/5
 */
public class Solution {

    @Test
    public void test() {
        int [] pre = {1,2,4,7,3,5,6,8};
        int [] in =  {4,7,2,1,5,3,8,6};

        TreeNode root = reConstructBinaryTree(pre, in);
        System.out.println(root);


    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(null == pre || pre.length <= 0) {
            return null;
        }
        int length = in.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int j = 0; j < length; j++) {
            map.put(in[j], j);
        }

        // 重构二叉树
        TreeNode node = rebuild(pre, in, 0, length-1, 0, length-1, map);

        return node;


    }

    private TreeNode rebuild(int[] pre, int[] in, int i, int j, int m, int n,
                             HashMap<Integer, Integer> map) {
        if(i <= j) {
            int val = pre[i];
            TreeNode node = new TreeNode(val);
            int index = map.get(val);
            int length = index - m;
            TreeNode left = rebuild(pre, in, i+1, i+length, m, m+length-1, map);
            TreeNode right = rebuild(pre, in, i+length+1, j, index+1, n, map);
            node.left = left;
            node.right = right;
            return node;
        }

        return null;
    }


}

