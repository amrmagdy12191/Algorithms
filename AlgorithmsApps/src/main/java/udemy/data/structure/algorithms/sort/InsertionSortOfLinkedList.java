package udemy.data.structure.algorithms.sort;

public class InsertionSortOfLinkedList {

	private Node head;
	private Node tail;
	private int length;

	class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public InsertionSortOfLinkedList(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public int getLength() {
		return length;
	}

	public void makeEmpty() {
		head = null;
		tail = null;
		length = 0;
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}

	public void append(int value) {
		Node newNode = new Node(value);
		if (length == 0) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		length++;
	}

	// Function to perform insertion sort on the linked list
	public void insertionSort() {
		if (head == null || head.next == null) {
			return; // List is empty or has one element, so it's already sorted
		}

		Node sorted = null; // Initialize the sorted part of the list
		Node current = head; // Current node to be inserted into the sorted list

		while (current != null) {
			Node next = current.next; // Store the next node
			sorted = sortedInsert(sorted, current); // Insert the current node into the sorted part
			current = next; // Move to the next node
		}

		head = sorted; // Update the head to the sorted part
	}
	
	// Helper function to insert a node into the sorted part of the list
    private Node sortedInsert(Node sorted, Node newNode) {
        // Case 1: If the sorted list is empty or the new node is smaller than the head
        if (sorted == null || sorted.value >= newNode.value) {
            newNode.next = sorted;
            return newNode;
        }

        // Case 2: Find the correct position to insert the new node
        Node current = sorted;
        while (current.next != null && current.next.value < newNode.value) {
            current = current.next;
        }

        // Insert the new node
        newNode.next = current.next;
        current.next = newNode;
        return sorted;
    }
    
    public static void main(String[] args) {

        InsertionSortOfLinkedList myLinkedList = new InsertionSortOfLinkedList(4);
        myLinkedList.append(2);
        myLinkedList.append(6);
        myLinkedList.append(5);
        myLinkedList.append(1);
        myLinkedList.append(3);


        System.out.println("Unsorted Linked List:");
        myLinkedList.printList();

        myLinkedList.insertionSort();

        System.out.println("\nSorted Linked List:");
        myLinkedList.printList();

        /*
            EXPECTED OUTPUT:
            ----------------
            Unsorted Linked List:
            4
            2
            6
            5
            1
            3
            
            Sorted Linked List:
            1
            2
            3
            4
            5
            6

        */

    }

}
