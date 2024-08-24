package udemy.data.structure.algorithms.sort;

import java.util.Iterator;

public class BubbleSortOfLinkedList {
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

    public BubbleSortOfLinkedList(int value) {
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
    
    // Function to perform bubble sort on the linked list
    public void bubbleSort() {
        if (head == null) {
            return;
        }

        boolean swapped;
        Node current;
        Node end = null;

        // Keep traversing until no swaps occur in a full pass
        do {
            swapped = false;
            current = head;

            while (current.next != end) {
                if (current.value > current.next.value) {
                    // Swap the data
                    int temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;
                    swapped = true;
                }
                current = current.next;
            }
            end = current; // Move the end marker back, as the largest element is in place

        } while (swapped); // If any swap occurred, repeat
    }
    
    public static void main(String[] args) {

    	BubbleSortOfLinkedList myLinkedList = new BubbleSortOfLinkedList(4);
        myLinkedList.append(2);
        myLinkedList.append(6);
        myLinkedList.append(5);
        myLinkedList.append(1);
        myLinkedList.append(3);



        System.out.println("Unsorted Linked List:");
        myLinkedList.printList();

        myLinkedList.bubbleSort();

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
