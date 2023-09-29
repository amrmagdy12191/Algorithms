package udemy.data.structure.algorithms.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
	Node head;
	Node tail;
	int length;

	public LinkedList(String value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + ",");
			temp = temp.next;
		}
		System.out.println();

	}

	public void append(String value) {
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

	public Node removeLast() {
		if (length == 0)
			return null;

		Node currentNode = head;
		Node previousNode = head;
		while (currentNode.next != null) {
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		tail = previousNode;
		tail.next = null;
		length--;

		if (length == 0) {
			head = null;
			tail = null;
		}

		return currentNode;

	}

	public void prepend(String value) {
		Node newNode = new Node(value);
		if (length == 0) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		length++;

	}

	public Node removeFirst() {
		if (length == 0)
			return null;
		Node temp = head;
		head = head.next;
		temp.next = null;
		length--;

		if (length == 0) {
			tail = null;
		}
		return temp;

	}

	public Node remove(int index) {
		if (length == 0 || index >= length || index < 0)
			return null;
		if (index == 0)
			return removeFirst();
		if (index == length - 1)
			return removeLast();

		Node previousNode = get(index - 1);
		Node temp = previousNode.next;
		previousNode.next = temp.next;
		temp.next = null;
		length--;
		return temp;

	}

	public Node get(int index) {
		if (index < 0 || index >= length)
			return null;

		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;

	}

	public boolean set(int index, String value) {
		Node temp = get(index);
		if (temp != null) {
			temp.value = value;
			return true;
		}
		return false;
	}

	public boolean insert(int index, String value) {
		if (index < 0 || index > length)
			return false;

		if (index == 0) {
			prepend(value);
			return true;
		}

		if (index == length) {
			append(value);
			return true;
		}
		
		Node newNode = new Node(value);
		
		Node prev = get(index - 1);
		Node nextNode = prev.next;
		prev.next = newNode;
		newNode.next = nextNode;

		length++;
		
		return true;

	}

	public void reverse() {
		if (length == 0 || length == 1)
			return;
		Node temp = head;
		head = tail;
		tail = temp;

		Node after = temp.next;
		Node before = null;
		for (int i = 0; i < length; i++) {
			after = temp.next;
			temp.next = before;
			before = temp;
			temp = after;
		}

	}
	
	public Node findMiddleNode(){
		if(head == null) return null;
		if(head.next == null) return head;
		
	    Node fastPointer = head;
	    
	    Node temp = head;
	    while(fastPointer != null && fastPointer.next != null) {
	    	temp = temp.next;
	    	fastPointer = fastPointer.next.next;
	    }
	    
	    return temp;
	}
	
	public boolean hasLoop(){
		if(length == 0) return false;
		Set<Node> hashSet = new HashSet<>();
		Node temp = head;
		while(temp.next != null){
			
			hashSet.add(temp);
			if(hashSet.contains(temp.next))
				return true;
			
			temp = temp.next;
		}
	    
	    return false;
	}

// tortoise and hare algorithm	
//	0 1 2 3 4 5 6 7 1
//
//	temp         0 2 3 4 5 6 7 1 2
//	Fastpointer  1 3 5 7 2 4 6 7 2
//
//	0 1 2 3 4 5 6 1
//
//	temp         0 2 3 4 5 6 1
//	Fastpointer  1 3 5 1 3 5 1
	
	public boolean detectLoop() {
		if(head == null || head.next == null) return false;
		Node tortoise = head;
		Node hare = head.next;
		while(hare != null && hare.next != null) {
			if(tortoise.equals(hare))
				return true;
			hare = hare.next;
			tortoise = tortoise.next.next;
		}
		
		return false;
	}
	
	public Node findKthFromEnd(int k) {
		int n = 0;
        Node curr = head;
 
        // count the total number of nodes in the linked list
        while (curr != null)
        {
            curr = curr.next;
            n++;
        }
 
        // if the total number of nodes is more than or equal to `k`
        if (n >= k)
        {
            // return (n-k+1)'th node from the beginning
            curr = head;
            for (int i = 0; i < n - k; i++) {
                curr = curr.next;
            }
        }
 
        return curr;
	}
	
	//Linked List: 3 -> 8 -> 5 -> 10 -> 2 -> 1 x: 5	
    public void partitionList(int x){
        if(head == null || head.next == null) return;
        
        Node pre = null;
        Node after = null;
        Node afterHead = null;
        Node preHead = null;
        Node middleHead = null;
        
        Node temp = head;
        
        Node middle= null;
        while(temp != null){
        	if(Integer.parseInt(temp.value) == x) {
        		if(middle == null) {
        			middle = temp;
        			middleHead = temp;
        		}else {
        			middle.next = temp; 
        			middle = middle.next;
        		}
        	}
            if(Integer.parseInt(temp.value) < x){
                	if(pre == null) {
                		pre = temp;
                		preHead = temp;
                	}else {
                		pre.next = temp;
                		pre = pre.next;
                	}
                //pre.next = null;
            }else if(Integer.parseInt(temp.value)> x){
                if(after == null){
                	afterHead = temp;
                    after = temp;
                }else{
                    after.next = temp;
                    after = after.next;
                }
            }
            
            temp = temp.next;
            
            if(pre != null)
            	pre.next = null;
            
            if(middle != null)
            	middle.next = null;
            
            if(after != null)
            	after.next = null;
        }
        
        if(pre == null) {
        	if(middle != null) {
        		middle.next = afterHead;
        		head = middleHead;
        	}
        }else {
        	if(middle == null) {
            	pre.next = afterHead;
        		head = preHead;
        	}else {
            	pre.next = middle;
                middle.next = afterHead;
                head = preHead;
            }
        } 
    }
    
    // removeDuplicates
    public void removeDuplicates() {
    	Node prt1 = null, prt2 = null, dup = null;
    	
    	prt1 = head;
    	while(prt1 != null && prt1.next != null) {
    		prt2 = prt1;
    		while(prt2.next != null) {
    			if(Integer.parseInt(prt1.value) == Integer.parseInt(prt2.next.value)){
    				prt2.next = prt2.next.next;
    				System.gc();
    			}else {
    				prt2 =prt2.next;
    			}
    		}
    		prt1 = prt1.next;
    	}
    }
    
    
    // reverseBetween
    public void reverseBetween(int m, int n) {
    	if(head == null || head.next == null) return;
    	
    	Node preNode = null, preMNode = null,
    	preNNode = null, mNode = null, nNode = null,
    	temp = head;
    	int index = 0;
    	while(temp.next != null) {
    		if(index == m) {
    			mNode= temp;
    			preMNode = preNode;
    		}else if(index == n) {
    			nNode = temp;
    			preNNode = preNode;
    		}
    		
    		if(mNode != null && nNode != null)
    			break;
    		
    		preNode = temp;
    		temp = temp.next;
    		index ++;		
    	}
    	
    	if(mNode != null && nNode != null) {
    		Node aftermNode = mNode.next;
    		mNode.next = null;
    		
    		Node afternNode = nNode.next;
    		nNode.next = null;
    		
    		nNode.next = aftermNode;
    		mNode.next = afternNode;
    		
    		if(preMNode != null)
    			preMNode.next = nNode;  
    		
    		if(preNNode != null)
    			preNNode.next = mNode;
    		
    	}
    	
    }
    


}
