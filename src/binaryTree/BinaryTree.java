package binaryTree;

public class BinaryTree {
	
	private Node root = null;
	
	BinaryTree (int value){
		root = new Node(value);
		root.leftChild = null;
		root.rightChild = null;
	}
	
	//查找数据
	public Node findKey(int value){
		Node current = root;
		while(true){
			if(value == current.value){
				return current;
			}else if(value < current.value){
				current = current.leftChild;
			}else{
				current = current.rightChild;
			}
			
			if(current ==null){
				return null;
			}
		}
	}
	
	//插入数据
	public String insert(int value){
		String error = null;
		Node node = new Node(value);
		if(root ==null){
			root = node;
		}else{
			Node current = root;
			Node parent = null;
			while(true){
				if(value < current.value){
					parent = current;
					current = current.leftChild;
					if(current == null){
						parent.leftChild = node;
						break;
					}
				}else if(value > current.value){
					parent = current;
					current = current.rightChild;
					if(current == null){
						parent.rightChild = node;
						break;
					}
				}else{
					error = "already exists the same value in the tree.";
				}
			}
		}
		
		return error;
	}
	
	//中序遍历的递归实现
	public void inOrderTraverse() {
		System.out.println("中序遍历：");
		inOrderTraverse(root);
		System.out.println();
	}

	private void inOrderTraverse(Node node) {
		// TODO Auto-generated method stub
		if(node ==null)
			return ;
		inOrderTraverse(node.leftChild);
		node.display();
		inOrderTraverse(node.rightChild);
		
	}
	
	//前序遍历的递归实现
	public void preOrderTraverse(){
		System.out.println("前序遍历：");
		preOrderTraverse(root);
		System.out.println();
	}

	private void preOrderTraverse(Node node) {
		// TODO Auto-generated method stub
		if(node == null)
			return ;
		node.display();
		preOrderTraverse(node.leftChild);
		preOrderTraverse(node.rightChild);
	}
	
	//后续遍历的递归实现
	public void postOrderTraverse(){
		System.out.println("后续遍历：");
		postOrderTraverse(root);
		System.out.println();
	}

	private void postOrderTraverse(Node node) {
		// TODO Auto-generated method stub
		if(node == null){
			return ;
		}
		postOrderTraverse(node.leftChild);
		postOrderTraverse(node.rightChild);
		node.display();
	}
	
	
}
