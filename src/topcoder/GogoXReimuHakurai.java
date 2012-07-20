package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class GogoXReimuHakurai {
	// Find # unique paths from node 0 to node N-1
	public int solve(String[] choices) {
		final int numNodes = choices.length;
		final boolean[][] graph = new boolean[numNodes][numNodes];
		for (int i = 0; i < numNodes - 1; ++i) {
			for (int j = i + 1; j < numNodes; ++j) {
				graph[i][j] = choices[i].charAt(j) == 'Y' ? true : false;
			}
		}
		return BFS(0, numNodes - 1, graph, numNodes);		
	}
	
	private class Path implements Comparable<Path> {
		ArrayList<Integer> nodes;
		int endNode;
		int len;
		
		public int compareTo(Path e) {
			return 0;
		}
		
		public Path (final ArrayList<Integer> path, int e){
			nodes = (ArrayList<Integer>)path.clone(); 
			endNode = e;
			len = nodes.size();
		}
		
		public String toString() {
			StringBuilder s = new StringBuilder();
			for(int i : nodes) {
				s.append(i);
				s.append(" -> ");
			}
			s.append(endNode);
			return s.toString();
		}
	}
	
	public int BFS(int startNode, int endNode, boolean[][] graph, final int numNodes) {
		boolean[] visited = new boolean[numNodes];
		for(int i=0; i<numNodes; ++i) {
			Arrays.fill(visited, false);
		}
		LinkedList<Path> q = new LinkedList<Path>();
		q.add(new Path(new ArrayList(), 0));
		int result = 0;
		while(!q.isEmpty()) {
			Path e = q.removeFirst(); 
			if(e.endNode == endNode) {
				System.out.println(e);
				result += 1;
			} else {
				e.nodes.add(e.endNode);
				for(int i=e.endNode + 1; i<numNodes; ++i) {
					if(graph[e.endNode][i]) {
						q.add(new Path(e.nodes, i));
						visited[i] = true;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;

		time = System.currentTimeMillis();
		answer = new GogoXReimuHakurai().solve(new String[] {"NYYYY", "NNYYY", "NNNYY", "NNNNY", "NNNNN"});
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 7;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new GogoXReimuHakurai().solve(new String[] { "NYNY", "NNYY",
				"NNNY", "NNNN" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 3;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new GogoXReimuHakurai().solve(new String[] { "NNY", "NNY",
				"NNN" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 1;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new GogoXReimuHakurai().solve(new String[] { "NN", "NN" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 0;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();

		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out
					.println("You're a stud (at least on the test data)! :-D ");
	}

}
// Powered by [KawigiEdit] 2.0!