package udemy.data.structure.algorithms.bst;

public class Main {

	public static void main(String[] args) {
		 BinarySearchTree myBST = new BinarySearchTree();

	        myBST.insert(2);
	        myBST.insert(1);
	        myBST.insert(3);

	        /*
	               2
	              / \
	             1   3
	        */

	        System.out.println( "Root: " + myBST.getRoot().value );
	        System.out.println( "Root->Left: " + myBST.getRoot().left.value );
	        System.out.println( "Root->Right: " + myBST.getRoot().right.value );


	        myBST.deleteNode(2);

	        /*
	               3
	              / \
	             1  null
	        */


	        System.out.println( "\nRoot: " + myBST.getRoot().value );
	        System.out.println( "Root->Left: " + myBST.getRoot().left.value );
	        System.out.println( "Root->Right: " + myBST.getRoot().right );
	        
	        
	        /*
	            EXPECTED OUTPUT:
	            ----------------
				Root: 2
				Root->Left: 1
				Root->Right: 3

				Root: 3
				Root->Left: 1
				Root->Right: null

	        */
	        
	        
	        System.out.println("\n ****************** Breadth First Search *********************");
	        myBST = new BinarySearchTree();

	        myBST.insert(47);
	        myBST.insert(21);
	        myBST.insert(76);
	        myBST.insert(18);
	        myBST.insert(27);
	        myBST.insert(52);
	        myBST.insert(82);

	        
	        System.out.println( myBST.BFS() );

	        /*
	            EXPECTED OUTPUT:
	            ----------------
	            Breadth First Search:
	            [47, 21, 76, 18, 27, 52, 82]

	        */
	        
	        System.out.println("\n ****************** Depth First Search [Preorder] *********************");        
	        System.out.println( myBST.DFSPreOrder() );

	        /*
	            EXPECTED OUTPUT:
	            ----------------
	            DFS PreOrder:
	            [47, 21, 18, 27, 76, 52, 82]

	        */
	        
	        
	        System.out.println("\n ****************** Depth First Search [PostOrder] *********************");  
	        System.out.println( myBST.DFSPostOrder() );

	        /*
	            EXPECTED OUTPUT:
	            ----------------
	            DFS PostOrder:
	            [18, 27, 21, 52, 82, 76, 47]

	        */
	        
	        
	        System.out.println("\n ****************** Depth First Search [InOrder] *********************");
	        System.out.println( myBST.DFSInOrder() );

	        /*
	            EXPECTED OUTPUT:
	            ----------------
	            DFS InOrder:
	            [18, 21, 27, 47, 52, 76, 82]

	        */
	        


	}

}
