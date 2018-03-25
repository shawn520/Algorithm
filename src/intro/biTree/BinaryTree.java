package intro.biTree;

public class BinaryTree {

	private Node root = null;
	
	//构造函数
	BinaryTree(int value){
		root = new Node(value);
		root.leftChild = null;
		root.rightChild = null;
	}
	
	//查找数据
	public Node findKey(int value){
		Node current = root;
		Node result = null;
		while(true){
			if(current.value == value){
				result = current;
				break;
			}else if(current.value < value){
				current = current.rightChild;
			}else{
				current = current.leftChild;
			}
			
			if(current == null){
				break;
			}
		}
		return result;	
	}
	
	//插入数据
	public String insert(int value){
		String error = null;
		Node node = new Node(value);	//新建一个结点，值为value
		
		if(root == null){				//如果根节点为空的话，插入到根节点
			root = node;
			root.leftChild = null;
			root.rightChild = null;
		}else {
			Node current = root;
			Node parent = null;
			while(true){
				if(value<current.value){			//如果插入的值小于当前节点，递归查找左子树
					parent = current;
					current = current.leftChild;
					if(current == null){			//如果当前节点为空，则插入。
						parent.leftChild = node;
						break;
					}
				}else if(value > current.value){	//如果插入的值大于当前节点，递归查找右子树
					parent = current;
					current = current.rightChild;
					if(current == null){
						parent.rightChild = node;
						break;
					}
				}else {				//如果找到值相同节点，则什么也不做
					error = "having same value in binary tree.";
				}
			} 	//end of while	
		}
		return error;	
	}
}

