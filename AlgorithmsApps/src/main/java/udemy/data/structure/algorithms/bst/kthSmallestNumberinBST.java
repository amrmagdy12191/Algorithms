package udemy.data.structure.algorithms.bst;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class kthSmallestNumberinBST {
	private Node root;

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }
    
public static void main(String[] args) {
        
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        System.out.println(bst.kthSmallest(1));  // Expected output: 2
        System.out.println(bst.kthSmallest(3));  // Expected output: 4
        System.out.println(bst.kthSmallest(6));  // Expected output: 7
        
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }
	
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

}
