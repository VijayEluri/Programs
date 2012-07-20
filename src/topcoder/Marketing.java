package topcoder;

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class Marketing {
	boolean[][] competition;
	int[] colors;
	int numProds;
	boolean oddCycle = false;
	
	public long howMany(String[] compete) {
		numProds = compete.length;
		competition = new boolean[numProds][numProds];
		for(int i=0; i<numProds; ++i) {
			Arrays.fill(competition[i], false);
		}
		
		for(int i=0; i<numProds; ++i) {
			StringTokenizer st = new StringTokenizer(compete[i]);
			while(st.hasMoreTokens()) {
				final int nextProd = Integer.parseInt(st.nextToken());
				competition[i][nextProd] = true;
				competition[nextProd][i] = true;
			}
		}
		
		colors = new int[numProds];
		Arrays.fill(colors, 0);
		
		// Get number of connected components
		int numComponents = 0;
		for(int i=0; i<numProds; ++i) {
			if(colors[i] == 0) {
				dfs(i, 1);
				++numComponents;
			}
		}
		if(oddCycle) {
			return -1;
		}
		return (long)Math.pow(2, numComponents);
	}	
	
	public void dfs(final int node, final int color) {
		if(colors[node] != 0) {
			if(colors[node] != color) {
				oddCycle = true;	
			}			
			return;
		}
		
		colors[node] = color;
		for(int i=0; i < numProds; ++i) {
			if(competition[node][i]) {
				dfs(i, 3 - color);
			}
		}
	}

	public static void main(String[] args) {
		long time;
		long answer;
		boolean errors = false;
		long desiredAnswer;

		time = System.currentTimeMillis();
		answer = new Marketing().howMany(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "0"});
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 2L;
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
		answer = new Marketing().howMany(new String[] { "1", "2", "0" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = -1L;
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
		answer = new Marketing().howMany(new String[] { "1", "2", "3", "0",
				"0 5", "1" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 2L;
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
		answer = new Marketing().howMany(new String[] { "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 1073741824L;
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
		answer = new Marketing().howMany(new String[] { "1", "2", "3", "0",
				"5", "6", "4" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = -1L;
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