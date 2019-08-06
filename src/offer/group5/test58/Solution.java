package offer.group5.test58;


/**
 * 二叉树的下一个结点
 * 题目描述
 * 给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，
 * 同时包含指向父结点的指针。
 *
 * 分析：
 * 画一个二叉树，写出中序遍历的序列。
 * 然后分析下一个节点的情况。
 *
 * 如果节点存在右子树，则为右子树的递归左子节点。
 *
 * 如果不存在右子树且为父节点的左子节点，则下一个节点为父节点
 * 如果不存在右子树且为父节点的右子节点，
 * 则递归向上，直到为父节点的左子节点，并返回父节点。
 *
 *
 * @author Shawn
 * @date 2019/8/5
 */
public class Solution {

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (null == pNode) {
            return null;
        }

        // 如果有右子树
        if(null != pNode.right) {
            TreeLinkNode node = pNode.right;
            while (null != node.left) {
                node = node.left;
            }
            return node;
        }


        // 如果没有父节点，且父节点不为空
        if(null != pNode.next) {
            TreeLinkNode parent = pNode.next;
            // 如果没有右子树且为父节点的左子树
            if(pNode == parent.left) {
                return parent;
            }

            // 如果为父节点的右子树
            while (parent != null) {
                if(pNode == parent.left ) {
                    return parent;
                }

                if(pNode == parent.right) {
                    pNode = parent;
                    parent = pNode.next;
                }
            }

        }
        return null;
    }
}

