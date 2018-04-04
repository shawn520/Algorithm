package binaryTree;

public class Demo {

	public static void main(String[] args) {
		BinaryTree btree = new BinaryTree(7);
		int [] a = {5,4,6,10,9,12};
		
		for(int i=0;i<a.length;i++){
			btree.insert(a[i]);
		}
		
//		btree.inOrderTraverse();
//		btree.preOrderTraverse();
//		btree.postOrderTraverse();
		//btree.inOrderByStack();
		//btree.preOrderByStack();
		btree.postOrderByStack();
	}
}
