package udemy.data.structure.algorithms.bst;

public class BinarySearchTree {
	Node root;
	
	public boolean insert(int value) {
		Node newNode = new Node(value);
		if(root == null) {
			root = newNode;
			return true;
		}
		Node temp = root;
		while(true) {
			if(newNode.value == temp.value) return false;
			
			if(newNode.value < temp.value) {
				if(temp.left == null) {
					temp.left = newNode;
					return true;
				}
				temp = temp.left;
			}
			
			if(newNode.value > temp.value) {
				if(temp.right == null) {
					temp.right = newNode;
					return true;
				}
				temp = temp.right;
			}
		}
	}
	
	public boolean contains(int value) {
		if(root == null) return false;
		
		Node temp = root;
		while(temp != null) {
			if(value < temp.value) {
				temp = temp.left;
			}else if(value > temp.value) {
				temp = temp.right;
			}else {
				return true;
			}
		}
		
		return false;
	}
	
	
	
	class Node{
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		
		
	}

}
