// Problem statement: http://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009
package topcoder;

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class BadNeighbors {
	int[][] dptable;
	public int maxDonations(int[] donations) {
		dptable = new int[2][donations.length];
		Arrays.fill(dptable[0], -1);
		Arrays.fill(dptable[1], -1);
		return Math.max(donations[0] + max(donations, true, 2), max(donations, false, 1));
	}
	
	public int max(final int[] donations, final boolean oneGave, final int idx) {
		if(idx >= donations.length) {
			return 0;
		}
		
		if(idx == donations.length - 1) { 
			if(oneGave) {
				return 0; 
			} else {
				return donations[donations.length - 1];
			}
		}
		
		final int result;
		if(dptable[oneGave ? 0 : 1][idx] != -1) {
			result = dptable[oneGave ? 0 : 1][idx];
		} else {
			result = Math.max(max(donations, oneGave, idx + 2) + donations[idx], max(donations, oneGave, idx + 1));
			dptable[oneGave ? 0 : 1][idx] = result;	
		}		
		return result;
	}

	public static void main(String[] args) {
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;

		time = System.currentTimeMillis();
		answer = new BadNeighbors()
				.maxDonations(new int[] { 10, 3, 2, 5, 7, 8 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 19;
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
		answer = new BadNeighbors().maxDonations(new int[] { 11, 15 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 15;
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
		answer = new BadNeighbors().maxDonations(new int[] { 7, 7, 7, 7, 7, 7,
				7 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 21;
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
		answer = new BadNeighbors().maxDonations(new int[] { 1, 2, 3, 4, 5, 1,
				2, 3, 4, 5 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 16;
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
		answer = new BadNeighbors().maxDonations(new int[] { 94, 40, 49, 65,
				21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12, 72, 74, 29,
				95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7,
				36, 57, 86, 81, 72 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 2926;
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