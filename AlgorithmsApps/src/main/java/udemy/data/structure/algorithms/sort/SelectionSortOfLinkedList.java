package udemy.data.structure.algorithms.sort;

public class SelectionSortOfLinkedList {
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

    public SelectionSortOfLinkedList(int value) {
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
    
        // Function to perform selection sort on the linked list
    public void selectionSort() {
        Node temp = head;

        // Traverse the entire linked list
        while (temp != null) {
            Node min = temp;
            Node r = temp.next;

            // Traverse the unsorted part of the list and find the minimum node
            while (r != null) {
                if (r.value < min.value) {
                    min = r;
                }
                r = r.next;
            }

            // Swap the value of the current node with the minimum node found
            int tempData = temp.value;
            temp.value = min.value;
            min.value = tempData;

            // Move to the next node in the list
            temp = temp.next;
        }
    }
    
    public static void main(String[] args) {

    	SelectionSortOfLinkedList myLinkedList = new SelectionSortOfLinkedList(4);
        myLinkedList.append(2);
        myLinkedList.append(6);
        myLinkedList.append(5);
        myLinkedList.append(1);
        myLinkedList.append(3);



        System.out.println("Unsorted Linked List:");
        myLinkedList.printList();

        myLinkedList.selectionSort();

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
