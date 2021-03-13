package misc;

import java.io.*;
import java.util.*;

// This class represents an undirected graph using adjacency list 
// representation 
class Graph2 {
	private int V; // No. of vertices

	// Array of lists for Adjacency List Representation
	private List<List<Integer>> adj;
	int time = 0;

	// Constructor
	Graph2(int v) {
		V = v;
		adj = new ArrayList<>();
		for (int i = 0; i < v; ++i) {
			adj.add(new ArrayList<Integer>());
		}
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj.get(v).add(w); // Add w to v's list.
		adj.get(w).add(v); // Add v to w's list
	}

	
	void articulationPoint() {
		boolean[] visited = new boolean[V];
		int[] dist = new int[V];
		int[] low = new int[V];
		int parent[] = new int[V];
		boolean ap[] = new boolean[V];
		
		
	}
	

	// Driver method
	public static void main(String args[]) {
		Graph2 g1 = new Graph2(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		System.out.println(g1.adj);
		System.out.println("Articulation points in first graph ");
		g1.articulationPoint();

		System.out.println("Articulation points in Second graph");
		Graph2 g2 = new Graph2(4);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(2, 3);
		System.out.println(g2.adj);
		
		System.out.println();

		System.out.println("Articulation points in Third graph ");
		Graph2 g3 = new Graph2(7);
		g3.addEdge(0, 1);
		g3.addEdge(1, 2);
		g3.addEdge(2, 0);
		g3.addEdge(1, 3);
		g3.addEdge(1, 4);
		g3.addEdge(1, 6);
		g3.addEdge(3, 5);
		g3.addEdge(4, 5);
		
		System.out.println(g3.adj);
	}
}