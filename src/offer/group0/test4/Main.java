package offer.group0.test4;

public class Main {
    public static void main(String [] args) {

        int [] pre = {1,2,3,4,5,6,7};
        int [] in = {3,2,4,1,6,5,7};

        Solution solution = new Solution();

        TreeNode treeNode = solution.reConstructBinaryTree(pre,in);

    }
}
