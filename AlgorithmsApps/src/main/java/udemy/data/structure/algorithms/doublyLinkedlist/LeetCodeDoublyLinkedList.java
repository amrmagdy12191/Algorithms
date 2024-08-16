package udemy.data.structure.algorithms.doublyLinkedlist;

import java.util.List;

public class LeetCodeDoublyLinkedList extends DoublyLinkedList {
	
	public LeetCodeDoublyLinkedList(Object value) {
		super(value);
	}
	
	/**
	 * Swap First and Last Node Values in a Doubly Linked List.
		Given a doubly linked list, write a method called swapFirstLast() that swaps the values of the first and last nodes in the list.	
		If the length of the list is less than 2, the method should not perform any operation.
	 */
	public void swapFirstLast() {
		if(length < 2) return;
		
		
		Node afterHead = head.next;
		Node prevTail = tail.prev;
		Node temp = head;
		head = tail;
		tail = temp;
			
		head.prev = null;
		tail.next = null;
		
		if(afterHead != null) {
			head.next = afterHead;
			afterHead.prev = head;
		}
		
		if(prevTail != null) {
			tail.prev = prevTail;
			prevTail.next = tail;
		}
		
	}
	
	/**
	 * Implement a method called reverse() that reverses the order of the nodes in the list.
	 */
	public void reverse() {
		if(length == 0 || length == 1) return;
		
		Node temp = null;
		Node current = head;
		
		Node newHead = tail;
		Node newTail = head;
		
		while(current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		
		head = newHead;
		tail = newTail;	
	}
	
	/**
	 * Write a method to determine whether a given doubly linked list reads the same forwards and backwards.
	 *  For example, if the list contains the values [1, 2, 3, 2, 1], then the method should return true, since the list is a palindrome.
	 * If the list contains the values [1, 2, 3, 4, 5], then the method should return false, since the list is not a palindrome.
	 */
	public boolean isPalindrome() {
		if(length == 0 || length == 1) return false;		
		if(length == 2 && head.value.equals(tail.value)) return true;
			
		int middleIndex = length/2;
		int index = 0;
		
		Node frontTemp = head;
		Node backTemp = tail;
		while(frontTemp.value.equals(backTemp.value)) {
			if(index < middleIndex) {
				frontTemp = frontTemp.next;
				backTemp = backTemp.prev;
				index ++;
			}else {
				return true;
			}		
		}
		
		return false;
	}
	
	/**
	 * Implement a method called swapPairs within the class that swaps the values of adjacent nodes in the linked list. 
	 * The method should not take any input parameters.
	 * Note: This DoublyLinkedList does not have a tail pointer which will make the implementation easier.
	 */
	public void swapPairs() {
		Node temp = head;
		//Node current = null;
		 
        /* Traverse only till there are atleast 2 nodes left */
        while (temp != null && temp.next != null) {
        	Object currentVlue = temp.value;
        	temp.value = temp.next.value;
        	temp.next.value = currentVlue;
        	temp = temp.next.next;
        }

		
	}
	
	

}
