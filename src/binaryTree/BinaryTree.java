package binaryTree;

import java.util.Stack;

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
	
	/*
	 * 中序遍历的非递归实现：
	 * 
	 * */
	public void inOrderByStack(){
		System.out.println("中序遍历的非递归实现：");
		Stack<Node> stack = new Stack<>();
		Node current = root;
		while(current != null || !stack.isEmpty()){
			while(current != null){
				stack.push(current);
				current = current.leftChild;
			}
			if(!stack.isEmpty()){
				current = stack.pop();
				current.display();
				current = current.rightChild;
				}
			}
		System.out.println();
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
	
	//前序遍历的非递归实现
	public void preOrderByStack(){
		System.out.println("中序遍历的非递归实现：");
		Stack<Node> stack = new Stack<>();
		Node current = root;
		while(current != null || !stack.isEmpty()){
			while(current != null){
				current.display();
				stack.push(current);
				current = current.leftChild;
			}
			if(!stack.isEmpty()){
				current = stack.pop();
				current = current.rightChild;
			}
			
		}
		System.out.println();
		
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
	
	//后续遍历的非递归实现：
	//这个自己写出来有难度，得多联系几次。
	public void postOrderByStack(){
		System.out.println("后序遍历的非递归实现：");
		Stack<Node> stack = new Stack<>();
		Node current = root;
		Node preNode = null;
		while(current !=null || !stack.isEmpty()){
			while(current != null){
				stack.push(current);
				current = current.leftChild;
			}
			if(!stack.isEmpty()){
				current = stack.peek().rightChild;
				if(current == null || current == preNode){
					current = stack.pop();
					current.display();
					preNode = current;
					current = null;
				}
			}
		}
		System.out.println();
	}
	
	
}
