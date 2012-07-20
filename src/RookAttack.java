import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Bharath Balakrishnan
 * @website www.bharathb.in
 * @modified by Sasidhar Kasturi sasik@cse.iitb.ac.in
 */

public class RookAttack {
	// public int[][] residueNetwork = { { 0, 7, 0, 0, 0, 0 },
	// { 7, 0, 6, 0, 1, 0}, { 0, 6, 0, 6, 0, 6 }, { 0, 0, 6, 0, 2, 2 },
	// { 0, 1, 0, 2, 0, 1 }, { 0, 0, 6, 2, 1, 0 } };
	/**
	 * @uml.property  name="residueNetwork" multiplicity="(0 -1)" dimension="2"
	 */
	public double[][] residueNetwork;
	/**
	 * @uml.property  name="backUpNetwork" multiplicity="(0 -1)" dimension="2"
	 */
	public double[][] backUpNetwork;
	/**
	 * @uml.property  name="n"
	 */
	public int N;

	public RookAttack(double[][] inputNetwork, int N) {
		this.N = N;
		residueNetwork = new double[N][N];
		backUpNetwork = new double[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				residueNetwork[i][j] = inputNetwork[i][j];
				backUpNetwork[i][j] = inputNetwork[i][j];
			}
		}
	}

	private double bfs() {
		Queue<Integer> vertices = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		int[] from = new int[N];
		Arrays.fill(from, -1);
		vertices.add(0);
		visited[0] = true;
		while (!vertices.isEmpty()) {
			int where = vertices.poll();
			visited[where] = true;
			boolean term = false;
			for (int i = 0; i < N; i++) {
				if (residueNetwork[where][i] > 0 && !visited[i]) {
					vertices.offer(i);
					visited[i] = true;
					from[i] = where;
					if (i == N - 1) {
						term = true;
						break;
					}
				}
			}
			if (term)
				break;
		}
		int where = N - 1;
		double pathCap = Double.MAX_VALUE;
		while (from[where] > -1) {
			int prev = from[where]; // the previous vertex
			pathCap = Math.min(pathCap, residueNetwork[prev][where]);
			where = prev;
		}
		where = N - 1;
		while (from[where] > -1) {
			int prev = from[where];
			residueNetwork[prev][where] -= pathCap;
			residueNetwork[where][prev] += pathCap;
			where = prev;
		}
		if (pathCap == Double.MAX_VALUE)
			return 0.0;
		else
			return pathCap;
	}

	public double getMaximumBiPartiteMatching() {
		double ret = 0;
		while (true) {
			double pathCap = bfs();
			if (pathCap == 0)
				break;
			else
				ret += pathCap;
		}
		return ret;
	}

	public boolean[] isLabelChangedWithMinCut() {
		this.getMaximumBiPartiteMatching();
		boolean[] ret = new boolean[N - 2];
		for (int i = 0; i < N - 2; i++)
			ret[i] = true;
		for (int j = 1; j < N - 1; j++) {
			if (backUpNetwork[0][j] != 0 && residueNetwork[0][j] == 0) {
				ret[j - 1] = false;
			}
		}

		return ret;
	}

}