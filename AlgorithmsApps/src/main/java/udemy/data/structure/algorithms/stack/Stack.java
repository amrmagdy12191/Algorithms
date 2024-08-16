package udemy.data.structure.algorithms.stack;

public class Stack {
	private Node top;
	private int height;
	
	public Stack(Object value) {
		Node newNode = new Node(value);
		top = newNode;
		height = 1;
	}
	
	public void push(Object value) {
		Node newNode = new Node(value);
		if(top == null) {
			top = newNode;
		}else {
			newNode.next = top;
			top = newNode;
		}
		height++;
	}
	
	public Object pop() {
		if(top == null) return null;
		
		Node temp = top;
		top = top.next;
		temp.next = null;
		height--;
		
		return temp.value;
	}
	
	
	
	public void printStack() {
		Node temp = top;
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	public Node getTop() {
		return top;
	}

	public int getHeight() {
		return height;
	}

	public class Node{
		public Object value;
		public Node next;
		
		public Node(Object value) {
			this.value = value;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
	}

}
