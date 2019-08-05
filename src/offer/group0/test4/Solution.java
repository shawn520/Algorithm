package offer.group0.test4;

import org.junit.Test;

import java.util.Arrays;

/**
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

        if(null == pre || null == in || pre.length != in.length) {
            return null;
        }
        int val = pre[0];
        TreeNode node = new TreeNode(val);
        if(pre.length == 1) {
            return node;
        }
        int mid = Arrays.binarySearch(in,val);
        if(mid > 0 ) {
            int [] pre1 = new int[mid];
            int [] in1 = new int[mid];
            for(int i = 0; i < mid; i++) {
                pre1[i] = pre[i+1];
                in1[i] = in[i];
            }
            node.left = reConstructBinaryTree(pre1, in1);
        }

        if(mid >= 0 && mid < in.length -1) {
            int length = in.length - mid - 1;
            int [] pre2 = new int [length];
            int [] in2 = new int [length];
            for(int i = 0; i < length; i++) {
                pre2[i] = pre[i+mid+1];
                in2[i] = in[i+mid+1];
            }
            node.right = reConstructBinaryTree(pre2, in2);
        }
        return node;
    }


}

