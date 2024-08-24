package udemy.data.structure.algorithms.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import udemy.data.structure.algorithms.bst.kthSmallestNumberinBST.Node;

public class BinarySearchTree {
	Node root;
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

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
	
    public boolean rContains(int value){
        return rContains(root, value);
    }
    
    public boolean rContains(Node node, int value){
        if(node == null) return false;
        
        if(value < node.value){
            return rContains(node.left, value);
        }else if(value > node.value){
            return rContains(node.right, value);
        }else{
            return true;
        }
    }
    
    public void rInsert(int value) {
    	if(root == null)
    		root = new Node(value);
    	else
    		rInsert(root, value);
    }
    
    public Node rInsert(Node currentNode, int value) {
    	if (currentNode == null) return new Node(value);
    	if(value < currentNode.value) {
    		currentNode.left = rInsert(currentNode.left, value);
    	}else if(value > currentNode.value) {
    		currentNode.right = rInsert(currentNode.right, value);
    	}
    		
    	return currentNode;
    }
    
    public int minValue(Node currentNode) {
    	while(currentNode.left != null) {
    		currentNode = currentNode.left;
    	}
    	return currentNode.value;
    		
    }
    
    public void deleteNode(int value) {
    	root = deleteNode(root, value);
    }
    
    /**
     * Steps To delete : 
     * 1) check left node if value less than current node -> left node = recursive call to delete left Node
     * 2) check right node if value bigger than current node -> right node = recursive call to delete right Node
     * 3) then write stop condition at first of method -> check if currentNode == null then return null
     * 4) the remaining case is if current node is the value to delete, it has many cases
     * 5) start with simplest one if left and right are null then simply return null
     * 6) then check if left is null and it has right -> set current node value as minValue of right node, right node = recursive call to deleteNode(right, minValue)
     * 7) do the same for left side in right is null
     * 8) remain case is both left and right has values, then do the same as you did in case of left is null to get minValue in right side and put it in place of deleted value
     * 
     * @param currentNode
     * @param value
     * @return
     */
    public Node deleteNode(Node currentNode, int value) {
    	if (currentNode == null) return null;
    	
    	if(value < currentNode.value) {
    		currentNode.left=  deleteNode(currentNode.left, value);
    	}else if(value > currentNode.value) {
    		currentNode.right = deleteNode(currentNode.right, value);
    	}else {
    		if(currentNode.left == null && currentNode.right == null)
    			return null;
    		else if(currentNode.left == null) {
    			int minValue = minValue(currentNode.right);
    			currentNode.value = minValue;
    			currentNode.right = deleteNode(currentNode.right, minValue);
    		} else if(currentNode.right == null) {
    			int minValue = minValue(currentNode.left);
    			currentNode.value = minValue;
    			currentNode.left = deleteNode(currentNode.left, minValue);
    		} else {
    			int minValue = minValue(currentNode.right);
    			currentNode.value = minValue;
    			currentNode.right = deleteNode(currentNode.right, minValue);
    		}
    	}
    	
    	return currentNode;
    }
    
    /**
     *  BFS algorithm for trees is to maintain a queue of nodes that will ensure the order of traversal.
     *  At the beginning of the algorithm, the queue contains only the root node. We’ll repeat these steps as long as the queue still contains one or more nodes:
		
		1) Pop the first node from the queue
		2) add this node’s children to the end of the queue and repeat the steps till visit every node in the tree
     * @return
     */
    public ArrayList<Integer> BFS(){
    	Node currentNode = root;
    	Queue<Node> queue = new LinkedList<>();
    	ArrayList<Integer> results = new ArrayList<>();
    	if(currentNode != null)
    		queue.add(currentNode);
    	
    	while(queue.size() > 0) {
    		currentNode = queue.remove();
    		if(currentNode.left != null) {
    			queue.add(currentNode.left);
    		}
    		
    		if(currentNode.right != null) {
    			queue.add(currentNode.right);
    		}
    		
    		results.add(currentNode.value);
    	}
    	return results;
    	
    	
    }
    
    /**
     * add every node value in binary tree to list to print all
     * 1) start from root
     * 2) add the root to result list
     * 3) then if left not null -> make left as inner root and make recursive call(1,2,3,4 steps) by adding the node then call left until min left value
     * 4)then if right not null -> make left as right root and make recursive call(1,2,3,4 steps) by adding the node then call left until min left value 
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> DFSPreOrder(){
    	ArrayList<Integer> results = new ArrayList<>();
    	
    	class Traverse{
    		Traverse(Node currentNode){
    			results.add(currentNode.value);
    			
    			if(currentNode.left != null)
    				new Traverse(currentNode.left);
    			
    			if(currentNode.right != null)
    				new Traverse(currentNode.right);
    			
    		}
    	}
    	
    	// 1) starting point
    	new Traverse(root);
    	return results;
    }
    
    /**
     * add every node value in binary tree to list to print all
     * 1) start from root
     * 2) then if left not null -> make left as inner root and make recursive call(1,2,3,4 steps) by adding the node then call left until min left value
     * 3)then if right not null -> make left as right root and make recursive call(1,2,3,4 steps) by adding the node then call left until min left value 
     * 4) add the root to result list
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> DFSPostOrder(){
    	ArrayList<Integer> results = new ArrayList<>();
    	
    	class Traverse{
    		Traverse(Node currentNode){
    			if(currentNode.left != null)
    				new Traverse(currentNode.left);
    			
    			if(currentNode.right != null)
    				new Traverse(currentNode.right);
    			
    			results.add(currentNode.value);
    			
    		}
    	}
    	
    	new Traverse(root);
    	return results;
    }
    
    /**
     * add every node value in binary tree to list to print all
     * 1) start from root
     * 2) then if left not null -> make left as inner root and make recursive call(1,2,3,4 steps) by adding the node then call left until min left value
     * 4) add the root to result list
     * 3)then if right not null -> make left as right root and make recursive call(1,2,3,4 steps) by adding the node then call left until min left value 
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> DFSInOrder(){
    	ArrayList<Integer> results = new ArrayList<Integer>();
    	
    	class Traverse{
    		public Traverse(Node curreNode) {
				if(curreNode.left != null)
					new Traverse(curreNode.left);
				
				results.add(curreNode.value);
				
				if(curreNode.right != null)
					new Traverse(curreNode.right);
			}
    	}
    	new Traverse(root);
    	return results;
    	
    }
    
    public boolean isValidBST(){
    	return traverse(new ArrayList<>(), root);
    }
    
    private boolean traverse(ArrayList<Integer> numbers, Node node) {
    	boolean valid = true;
    	
    	if(node.left != null)
			valid = traverse(numbers, node.left);
    	
    	if(valid) {
    		for(int num:numbers) {
    			if(num > node.value)
    				return false;
    		}
    	
			numbers.add(node.value);
			
			if(node.right != null) {
				valid = traverse(numbers, node.right);
			}
    	}
		
		return valid;
    }
    
    /**
     * The method should use the in-order traversal technique to visit the nodes of the tree, i.e.,
     *  it should first visit the left child, then the parent, and finally the right child. 
     *  To implement this, use a Stack<Node> to store the nodes. 
     * Continue with the traversal as long as there are nodes in the stack or the current node is not null.
     * @param k
     * @return kth smallest number
     */
	public Integer kthSmallest(int k) {
		Stack<Integer> numberStack = new Stack<>();
		kthSmallest(numberStack, root);
		
		Integer smallest = null;
		for(int i = 0; i<k; i++) {
			smallest = numberStack.pop();
		}
		return smallest;
	}
	
	private void kthSmallest(Stack<Integer> numbersStack, Node node) {
		if(node.left != null)
			kthSmallest(numbersStack, node.left);
		numbersStack.push(node.value);
		if(node.right != null)
			kthSmallest(numbersStack, node.right);
	}
    

    

	
	
	
	class Node{
		int value;
		public Node left;
		public Node right;
		
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
