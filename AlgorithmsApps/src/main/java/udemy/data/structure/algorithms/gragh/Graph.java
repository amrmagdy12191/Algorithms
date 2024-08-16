package udemy.data.structure.algorithms.gragh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Graph {

    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public HashMap<String, ArrayList<String>> getAdjList() {
        return adjList;
    }

    public void printGraph() {
        System.out.println(adjList);
    }

	public boolean addVertex(String vertex) {
		if(adjList.get(vertex) == null) {
			adjList.put(vertex, new ArrayList<>());
			return true;
		}
		return false;
	}
	
	public boolean addEdge(String vertex1, String vertex2) {
		List<String> vertex1List = adjList.get(vertex1);
		List<String> vertex2List = adjList.get(vertex2);
		if(vertex1List != null && vertex2List != null) {
			vertex1List.add(vertex2);
			vertex2List.add(vertex1);
			return true;
		}
		return false;
	}
	
	public boolean removeEdge(String vertex1, String vertex2) {
		List<String> vertex1Edges = adjList.get(vertex1);
		List<String> vertex2Edges = adjList.get(vertex2);
		
		if(vertex1Edges != null && vertex2Edges != null) {
			vertex1Edges.remove(vertex2);
			vertex2Edges.remove(vertex1);
			return true;
		}
		
		return false;
	}
	
	public boolean removeVertex(String vertex) {
		List<String> vertexEdges = adjList.get(vertex);
		if(vertexEdges == null) return false;
		
		for (String othervertex : vertexEdges) {
			adjList.get(othervertex).remove(vertex);
		}
		adjList.remove(vertex);
		return true;
	}

}
