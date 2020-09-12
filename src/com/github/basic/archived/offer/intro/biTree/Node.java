package com.github.basic.archived.offer.intro.biTree;

public class Node {

	int value;
	Node leftChild;
	Node rightChild;
	
	Node (int value){
		this.value = value;
	}
	
	public void display(){
		System.out.print(this.value + "\t");
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
