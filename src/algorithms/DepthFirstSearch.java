package algorithms;

import java.util.HashSet;

import datastructures.Graph;
import datastructures.Node;

public class DepthFirstSearch {
	HashSet<Node> visited = new HashSet<Node>();
	public void dfs(Graph g, Node n) {
		visited.clear();
		visited.add(n);
	}
	
	public void dfs(Node n) {
		
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(Graph.getRandomGraph(10));
		DepthFirstSearch d = new DepthFirstSearch();
		d.dfs(g, new Node(0));
	}
}
