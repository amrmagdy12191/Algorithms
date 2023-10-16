package udemy.data.structure.algorithms.queue;


public class Queue {
	private Node first;
	private Node last;
	private int length;
	
	public Queue(Object value) {
		Node newNode = new Node(value);
		first = newNode;
		last = newNode;
		length = 1;
	}
	
	public void enqueue(Object value) {
		Node newNode = new Node(value);
		if(length == 0) {
			first = newNode;
			last = newNode;
		}else {
			last.next = newNode;
			last = newNode;
		}
		length++;
		
	}
	
	public Object dequeue() {
		if(length == 0) return null;
		Node temp = first;
		if(length == 1) {
			first = null;
			last = null;
		}else {
			first = first.next;
			temp.next = null;
		}
		length--;
		return temp.value;
	}
	
	public void printQueue() {
		Node temp = first;
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	public Node getFirst() {
		return first;
	}

	public Node getLast() {
		return last;
	}

	public int getLength() {
		return length;
	}

	public class Node{
		private Object value;
		private Node next;
		
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
