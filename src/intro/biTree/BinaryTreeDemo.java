package intro.biTree;

public class BinaryTreeDemo {  
    public static void main(String[] args) {  
    BinaryTree bt = new BinaryTree(52);  
    bt.insert(580);  
    bt.insert(12);  
    bt.insert(50);  
    bt.insert(58);  
    bt.insert(9);  
    bt.insert(888);  
    bt.insert(248);  
    bt.insert(32);  
    bt.insert(666);  
    bt.insert(455);  
    bt.insert(777);  
    bt.insert(999);  
    bt.inOrderTraverse();  
    bt.preOrderTraverse();  
    bt.postOrderTraverse();  
    System.out.println(bt.findKey(32));  
    System.out.println(bt.findKey(81));  
    System.out.println("最小值:" + bt.getMinValue());  
//  bt.delete(32);      //删除叶子节点  
//  bt.delete(50);      //删除只有一个左子节点的节点  
//  bt.delete(248);      //删除只有一个右子节点的节点  
//  bt.delete(248);      //删除只有一个右子节点的节点  
//  bt.delete(580);      //删除有两个子节点的节点，且后继节点为删除节点的右子节点的左后代  
//  bt.delete(888);      //删除有两个子节点的节点，且后继节点为删除节点的右子节点  
   // bt.delete(52);       //删除有两个子节点的节点，且删除节点为根节点  
      
    //bt.inOrderTraverse();  
    System.out.println("最大值:" + bt.getMaxValue()); 
    }  
}  
