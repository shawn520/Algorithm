package offer.group0.test4;

/**
 * 描述:输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {

        if(pre.length <=0 ){
            return null;
        }
        int val = pre[0];
        int index = 0;
        for(int i=0;i<in.length;i++){
            if(val == in[i]){
                index = i;
                break;
            }
        }
        int leftArrayLength = index;
        int [] left_in = new int[leftArrayLength];
        for(int i=0;i<index;i++) {
            left_in[i] = in[i];
        }

        int rightArrayLength = in.length - left_in.length - 1;
        int [] right_in = new int[rightArrayLength];
        for(int i=0;i<rightArrayLength;i++) {
            right_in[i] = in[i+leftArrayLength+1];
        }

        int [] left_pre = new int [leftArrayLength];
        for(int i=0;i<leftArrayLength;i++){
            left_pre[i] = pre[i+1];
        }

        int [] right_pre = new int [rightArrayLength];
        for(int i=0;i<rightArrayLength;i++) {
            right_pre[i] = pre[i+leftArrayLength+1];
        }

        TreeNode treeNode = new TreeNode(val);

        if(0 != pre.length) {
            treeNode.left = reConstructBinaryTree(left_pre, left_in);
            treeNode.right = reConstructBinaryTree(right_pre, right_in);
        }
        return treeNode;
    }
}