package binaryTree;

public class Demo {

	public static void main(String[] args) {
		BinaryTree btree = new BinaryTree(9);
		int [] a = {8,10,6,5};
		
		for(int i=0;i<a.length;i++){
			btree.insert(a[i]);
		}
		
		btree.inOrderTraverse();
		btree.preOrderTraverse();
		btree.postOrderTraverse();
	}
}
