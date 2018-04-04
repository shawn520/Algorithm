package binaryTree;

public class Node {
	int value;
	Node leftChild;
	Node rightChild;
	
	Node(int value){
		this.value = value;
	}
	
	public void display(){
		System.out.print(this.value + "\t");
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
}
