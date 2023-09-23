package udemy.data.structure.algorithms.doublyLinkedlist;

public class DoublyLinkedList {
	Node head;
	Node tail;
	int length;
	
	public DoublyLinkedList(Object value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length++;
	}
	
	public void append(Object value) {
		Node newNode = new Node(value);
		if(length==0) {
			head = newNode;
			tail = newNode;
			length++;
		}else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			length++;
		}
	}
	
	public Node removeLast() {
		if(length == 0) return null;
		Node temp = tail;
		if(length == 1) {
			head = null;
			tail = null;		
		}else {
			tail = tail.prev;
			tail.next = null;
			temp.prev = null;
		}
		length --;	
		return temp;
	}
	
	public void prepend(Object value) {
		Node newNode = new Node(value);
		if(length == 0) {
			head = newNode;
			tail = newNode;
		}else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
		length++;
	}
	
	public Node removeFirst() {
		if(length == 0) return null;
		Node temp = head;
		if(length == 1) {
			head = null;
			tail = null;
		}else {
			head = head.next;
			head.prev = null;
			temp.next = null;
		}
		
		length--;
		return temp;
	}
	
	public Node get(int index) {
		if(length == 0 || index < 0 || index >= length) return null;
		Node temp;
		if(index < length/2) {
			temp = head;
			for(int i = 0; i< index; i++) {
				temp = temp.next;
			}
		}else {
			temp = tail;
			for(int i = length-1; i>index; i--) {
				temp = temp.prev;
			}
		}
		return temp;
	}
	
	public boolean set(int index, Object value) {
		Node temp = get(index);
		if(temp != null) {
			temp.value = value;
			return true;
		}
		return false;
	}
	
	public boolean insert(int index, Object value) {
		if(index < 0 || index > length) return false;
		
		if(index == 0) {
			prepend(value);
			return true;
		}
		
		if(index == length) {
			append(value);
			return true;
		}
		
		Node newNode = new Node(value);
		Node before = get(index-1);
		Node after = before.next;
		before.next = newNode;
		after.prev = newNode;
		newNode.next = after;
		newNode.prev = before;
		length++;
		return true;
	}
	
	public Node remove(int index) {
		if(index <0 || index > length-1) return null;
		if (index == 0) return removeFirst();
		if(index == length-1) return removeLast();
		
		Node temp = get(index);
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		temp.prev = null;
		temp.next = null;
		
		length--;
		return temp;
	
	}
	
	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + ",");
			temp = temp.next;
		}
		System.out.println();

	}
	
	public class Node{
		Object value;
		Node next;
		Node prev;
		
		Node(Object value){
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

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}
		
	}

}
