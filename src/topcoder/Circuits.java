package topcoder;

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class Circuits {
	int[][] overallCost;
	public int howLong(String[] connects, String[] costs) {
		final int numNodes = connects.length;
		overallCost = new int[numNodes][numNodes];
		for(int i=0; i<numNodes; ++i) {
			Arrays.fill(overallCost[i], 0);
		}
		
		for(int i=0; i<numNodes; ++i) {
			final StringTokenizer connectTokenizer = new StringTokenizer(connects[i]);
			final StringTokenizer costTokenizer = new StringTokenizer(costs[i]);
			
			while(connectTokenizer.hasMoreTokens()) {
				final int targetNode = Integer.parseInt(connectTokenizer.nextToken());
				final int cost = Integer.parseInt(costTokenizer.nextToken());
				overallCost[i][targetNode] = cost;
			}
		}
		
		// Floyd-Warshall algorithm
		for(int k=0; k<numNodes; ++k) {
			for(int i=0; i<numNodes; ++i) {
				for(int j=0; j<numNodes; ++j) {
					if(overallCost[i][k] !=0 && overallCost[k][j] != 0 && overallCost[i][j] < overallCost[i][k] + overallCost[k][j]) {
						overallCost[i][j] = overallCost[i][k] + overallCost[k][j];
					}
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<numNodes; ++i) {
			for(int j=0; j<numNodes; ++j) {
				 max = Math.max(overallCost[i][j], max);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;

		time = System.currentTimeMillis();
		answer = new Circuits().howLong(new String[] { "1 2", "2", "" },
				new String[] { "5 3", "7", "" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 12;
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
		answer = new Circuits().howLong(new String[] { "1 2 3 4 5", "2 3 4 5",
				"3 4 5", "4 5", "5", "" }, new String[] { "2 2 2 2 2",
				"2 2 2 2", "2 2 2", "2 2", "2", "" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 10;
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
		answer = new Circuits().howLong(new String[] { "1", "2", "3", "", "5",
				"6", "7", "" }, new String[] { "2", "2", "2", "", "3", "3",
				"3", "" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 9;
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
		answer = new Circuits().howLong(new String[] { "", "2 3 5", "4 5",
				"5 6", "7", "7 8", "8 9", "10", "10 11 12", "11", "12", "12",
				"" }, new String[] { "", "3 2 9", "2 4", "6 9", "3", "1 2",
				"1 2", "5", "5 6 9", "2", "5", "3", "" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 22;
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
		answer = new Circuits().howLong(new String[] { "", "2 3", "3 4 5",
				"4 6", "5 6", "7", "5 7", "" }, new String[] { "", "30 50",
				"19 6 40", "12 10", "35 23", "8", "11 20", "" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 105;
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