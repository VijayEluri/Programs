import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;

public class AMLAssignment {

	/**
	 * @uml.property  name="noOfNodes"
	 */
	private int noOfNodes;
	/**
	 * @uml.property  name="noOfEdges"
	 */
	private int noOfEdges;
	/**
	 * @uml.property  name="noOfLabels"
	 */
	private int noOfLabels;
	/**
	 * @uml.property  name="nodePotentials" multiplicity="(0 -1)" dimension="2"
	 */
	double[][] nodePotentials;
	/**
	 * @uml.property  name="edgePotentials"
	 * @uml.associationEnd  qualifier="valueOf:java.lang.Integer [[D"
	 */
	private HashMap<Integer, double[][]> edgePotentials;
	/**
	 * @uml.property  name="edgeVars"
	 * @uml.associationEnd  qualifier="valueOf:java.lang.Integer I"
	 */
	private HashMap<Integer, int[]> edgeVars;
	/**
	 * @uml.property  name="labels" multiplicity="(0 -1)" dimension="1"
	 */
	public int[] labels;
	/**
	 * @uml.property  name="capacity" multiplicity="(0 -1)" dimension="2"
	 */
	double[][] capacity;
	/**
	 * @uml.property  name="energy"
	 */
	double energy = Double.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		AMLAssignment a = new AMLAssignment();
		a.readInput(args[0]);
		int[] optimalTillNow = new int[a.noOfNodes];
		for (int i = 0; i < a.noOfNodes; i++) {
			optimalTillNow[i] = 0;
		}
		System.out.println("No of nodes:" + a.noOfNodes);
		a.assignRandom();
		System.out.println("Labels Initial assignment "
				+ Arrays.toString(a.labels));
		String preAlpha = Arrays.toString(a.labels);

		while (true) {
			for (int alpha = 0; alpha < a.noOfLabels; alpha++) {
				a.prepareData(alpha);
				RookAttack r = new RookAttack(a.capacity, a.noOfNodes + 2);
				a.updateLabels(alpha, r.isLabelChangedWithMinCut());
				// System.out.println(Arrays.toString(a.labels));
			}

			if (a.getEnergy() > a.getEnergy(optimalTillNow)) {
				for (int j = 0; j < a.noOfNodes; j++) {
					optimalTillNow[j] = a.labels[j];
				}
			}

			if (preAlpha.compareTo(Arrays.toString(a.labels)) == 0)
				break;
			preAlpha = Arrays.toString(a.labels);
		}
		System.out.println("Optimal labelling:"
				+ Arrays.toString(optimalTillNow));
		System.out.println(a.getEnergy(optimalTillNow));
	}

	public void setLabels(int[] labels) {

	}

	public void updateLabels(int alpha, boolean[] mincut) {
		// System.out.println(Arrays.toString(mincut));
		int[] temp = new int[noOfNodes];
		for (int i = 0; i < noOfNodes; i++) {
			temp[i] = labels[i];
		}

		for (int i = 0; i < noOfNodes; i++) {
			if (mincut[i]) {
				temp[i] = alpha;
			}
		}
		if (getEnergy(temp) > getEnergy()) {
			for (int i = 0; i < noOfNodes; i++) {
				labels[i] = temp[i];
			}
		}
	}

	public void readInput(String inputFile) throws IOException {
		// Read file
		BufferedReader inputReader = new BufferedReader(new FileReader(
				inputFile));
		noOfNodes = Integer.parseInt(inputReader.readLine());
		noOfEdges = Integer.parseInt(inputReader.readLine());
		noOfLabels = 0;

		/** Read the node potentials **/
		int nodeId = 0;
		StringTokenizer st = new StringTokenizer(inputReader.readLine());
		nodeId = Integer.parseInt(st.nextToken());
		noOfLabels = Integer.parseInt(st.nextToken());
		nodePotentials = new double[noOfNodes][noOfLabels];

		for (int j = 0; j < noOfLabels; j++) {
			nodePotentials[0][j] = Double.parseDouble(st.nextToken());
		}

		for (int i = 1; i < noOfNodes; i++) {
			st = new StringTokenizer(inputReader.readLine());
			nodeId = Integer.parseInt(st.nextToken());
			st.nextToken();
			for (int j = 0; j < noOfLabels; j++) {
				nodePotentials[nodeId][j] = Double.parseDouble(st.nextToken());
			}
		}

		// System.out.println("No of nodes: " + noOfNodes);
		// System.out.println("No of edges: " + noOfEdges);
		// System.out.println("No of labels: " + noOfLabels);
		// System.out.println("Potentials");
		// for (int i = 0; i < noOfNodes; i++) {
		// System.out.println(Arrays.toString(nodePotentials[i]));
		// }

		edgePotentials = new HashMap<Integer, double[][]>();
		edgeVars = new HashMap<Integer, int[]>();
		double[][] tempPotential;
		int[] tempEdgeVars;
		/** Read the edge potentials **/
		for (int i = 0; i < noOfEdges; i++) {
			st = new StringTokenizer(inputReader.readLine());
			tempPotential = new double[noOfLabels][noOfLabels];
			tempEdgeVars = new int[2];
			tempEdgeVars[0] = Integer.parseInt(st.nextToken());
			tempEdgeVars[1] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < noOfLabels; j++)
				for (int k = 0; k < noOfLabels; k++) {
					tempPotential[j][k] = Double.parseDouble(st.nextToken());
				}

			edgeVars.put(i, tempEdgeVars);
			edgePotentials.put(i, tempPotential);
		}

		// for (int i = 0; i < noOfEdges; i++) {
		// tempPotential = edgePotentials.get(i);
		// tempEdgeVars = edgeVars.get(i);
		// System.out.print("Edge: " + (i + 1) + " ");
		// System.out.print(Arrays.toString(tempEdgeVars));
		// for (int j = 0; j < noOfLabels; j++) {
		// System.out.print(Arrays.toString(tempPotential[j]));
		// }
		// System.out.print("\n");
		// }
	}

	public int[] assignRandom() {
		labels = new int[noOfNodes];
		Random rand = new Random(System.currentTimeMillis());
		// Random rand = new Random();
		for (int i = 0; i < noOfNodes; i++) {
			// labels[i] = 2;
			labels[i] = rand.nextInt(noOfLabels);
			// System.out.println("Node " + (i + 1) + " : " + labels[i]);
		}
		return labels;
	}

	public void prepareData(int alpha) {
		capacity = new double[noOfNodes + 2][noOfNodes + 2];
		for (int i = 0, n = noOfNodes + 2; i < n; i++) {
			for (int j = 0; j < n; j++) {
				capacity[i][j] = 0;
			}
		}

		int beta = 0, gamma = 0;
		double[] thetas = new double[4];
		int[] presentEdge;
		double[][] tempEdgePots;

		// Add the 0-node and node-1 potentials.
		// 0 to node
		for (int j = 1; j < noOfNodes + 1; j++) {
			int nodeId = j - 1;

			if (labels[nodeId] == alpha) {
				capacity[0][j] = nodePotentials[nodeId][alpha];
				capacity[j][0] = capacity[0][j];
				capacity[noOfNodes + 1][j] += 1000;
				capacity[j][noOfNodes + 1] = capacity[noOfNodes + 1][j];
			} else {
				double temp1 = nodePotentials[nodeId][alpha];
				double temp2 = nodePotentials[nodeId][labels[nodeId]];
				double temp = Math.min(temp1, temp2);

				temp1 -= temp;
				temp2 -= temp;

				capacity[0][j] = temp1;
				capacity[j][0] = temp1;
				capacity[noOfNodes + 1][j] = temp2;
				capacity[j][noOfNodes + 1] = temp2;
			}
		}

		// System.out.println("Capacity: ");
		// for (int i = 0; i < noOfNodes + 2; i++) {
		// System.out.println(Arrays.toString(capacity[i]));
		// }
		// System.out.print("After node\n");

		int node1, node2;
		for (int i = 0; i < noOfEdges; i++) {
			presentEdge = edgeVars.get(i);
			node1 = presentEdge[0] + 1;
			node2 = presentEdge[1] + 1;
			tempEdgePots = edgePotentials.get(i);

			beta = labels[presentEdge[0]];
			gamma = labels[presentEdge[1]];
			// System.out.println("Beta: " + beta + ", Gamma: " + gamma);

			thetas[0] = tempEdgePots[alpha][alpha];
			thetas[1] = tempEdgePots[alpha][gamma];
			thetas[2] = tempEdgePots[beta][alpha];
			thetas[3] = tempEdgePots[beta][gamma];

			// System.out.println("Thetas: " + Arrays.toString(thetas));

			capacity[0][node1] = capacity[0][node1]
					+ (thetas[0] + thetas[1] - thetas[2] - thetas[3]) / 2;
			capacity[0][node2] = capacity[0][node2]
					+ (thetas[0] + thetas[2] - thetas[1] - thetas[3]) / 2;
			capacity[noOfNodes + 1][node1] = capacity[noOfNodes + 1][node1]
					+ (thetas[2] + thetas[3] - thetas[0] - thetas[1]) / 2;
			capacity[noOfNodes + 1][node2] = capacity[noOfNodes + 1][node2]
					+ (thetas[1] + thetas[3] - thetas[0] - thetas[2]) / 2;

			// Sysmmetric
			capacity[node1][0] = capacity[0][node1];
			capacity[node2][0] = capacity[0][node2];
			capacity[node1][noOfNodes + 1] = capacity[noOfNodes + 1][node1];
			capacity[node2][noOfNodes + 1] = capacity[noOfNodes + 1][node2];

			double min = Double.MAX_VALUE;
			for (double x : thetas)
				if (x < min)
					min = x;

			for (int k = 0; k < thetas.length; k++)
				thetas[k] -= min;

			capacity[node2][node1] = thetas[1] + thetas[2];
			capacity[node1][node2] = capacity[node2][node1];

		}

		// System.out.println("Capacity: ");
		// for (int i = 0; i < noOfNodes + 2; i++) {
		// System.out.println(Arrays.toString(capacity[i]));
		// }

	}

	public double getEnergy(int[] labels) {
		double ret = 0;
		for (int i = 0; i < noOfNodes; i++) {
			ret += nodePotentials[i][labels[i]];
		}

		for (int i = 0; i < noOfEdges; i++) {
			int node1 = edgeVars.get(i)[0];
			int node2 = edgeVars.get(i)[1];

			ret += edgePotentials.get(i)[labels[node1]][labels[node2]];
		}

		return ret;
	}

	public double getEnergy() {
		double ret = 0;
		for (int i = 0; i < noOfNodes; i++) {
			ret += nodePotentials[i][labels[i]];
		}

		for (int i = 0; i < noOfEdges; i++) {
			int node1 = edgeVars.get(i)[0];
			int node2 = edgeVars.get(i)[1];

			ret += edgePotentials.get(i)[labels[node1]][labels[node2]];
		}

		return ret;
	}

}
