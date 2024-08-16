package udemy.data.structure.algorithms.gragh;

public class Main {

    public static void main(String[] args) {

    	Graph myGraph = new Graph();

    	myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");

        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("A", "D");
        myGraph.addEdge("B", "D");
        myGraph.addEdge("C", "D");


        System.out.println("Graph before removeEdge():");
        myGraph.printGraph();

        myGraph.removeEdge("A", "B");

        System.out.println("\nGraph after removeEdge():");
        myGraph.printGraph();

        /*
            EXPECTED OUTPUT:
            ----------------
            Graph before removeEdge():
           	{A=[B, C, D], B=[A, D], C=[A, D], D=[A, B, C]}
            
            Graph after removeEdge():
            {A=[C, D], B=[D], C=[A, D], D=[A, B, C]}

        */
        

        myGraph.removeVertex("D");

        System.out.println("\nGraph after removeVertex():");
        myGraph.printGraph();
        
        /*
            EXPECTED OUTPUT:
            ----------------
            
            Graph after removeVertex():
            {A=[C], B=[], C=[A]}

        */


    }

}
