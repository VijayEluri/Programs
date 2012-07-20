package datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Graph {
	int[][] graph;
	int numNodes;
	public int getNumNodes() {
		return numNodes;
	}
	
	public Graph(int[][] graph) {
		this.graph = graph.clone();
		this.numNodes = graph.length;
	}
	
	public ArrayList<Node> getNeighbours(Node n) {
		ArrayList<Node> res = new ArrayList<Node>();
		for(int i=0; i<numNodes; ++i) {
			if(i != n.id && graph[i][n.id] != 0) {
				res.add(new Node(i));
			}
		}
		return res;
	}
	
	public static int[][] getRandomGraph(int numNodes) {
		Random r = new Random();
		int[][] graph = new int[numNodes][numNodes];
		for (int i = 0; i < numNodes; ++i) {
			Arrays.fill(graph[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < numNodes - 1; ++i) {
			for (int j = i + 1; j < numNodes; ++j) {
				graph[i][j] = graph[j][i] = r.nextInt(10);
			}
		}
		return graph;
	}
	
	public class Edge {  
		int startNode, endNode, weight;
		
		public Edge(int s, int e, int w) {
			startNode = s;
			endNode = e;
			weight = w;
		}
	}
}
