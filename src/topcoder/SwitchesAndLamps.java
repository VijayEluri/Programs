package topcoder;

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class SwitchesAndLamps {
	public int theMin(String[] switches, String[] lamps) {
		final int numLamps = lamps[0].length();
		final int sn[] = new int[numLamps];
		final int ln[] = new int[numLamps];
		Arrays.fill(sn, 0);
		Arrays.fill(ln, 0);
		
		for(int i=0, n=switches.length; i<n; ++i) {
			
		}
		return 0;
	}

	public static void main(String[] args) {
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;

		time = System.currentTimeMillis();
		answer = new SwitchesAndLamps().theMin(new String[] { "NYNN", "NNYN" },
				new String[] { "NNNY", "NNYN" });
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
		answer = new SwitchesAndLamps().theMin(new String[] { "YYN", "YNY",
				"YYN" }, new String[] { "YNY", "NYY", "YNY" });
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
		time = System.currentTimeMillis();
		answer = new SwitchesAndLamps().theMin(new String[] {
				"NYYYNYNNYYYNYNNNNY", "NYYYNYNNYYYNYNNNNY" }, new String[] {
				"YYYNNNYNNYNYNYNYNY", "YYYNNNYNNYNYYNNYNY" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = -1;
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
		answer = new SwitchesAndLamps().theMin(
				new String[] { "YYNNN", "NNYYN" }, new String[] { "NYNNY",
						"NNNYY" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = -1;
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
		answer = new SwitchesAndLamps().theMin(new String[] { "YNNYNNYNYY",
				"NYNNYNYNYN", "YNYNYYYYYN", "NNYYNYNYNN" }, new String[] {
				"NYYNYNNYNY", "NYYYNNYNNN", "YYYYNYNNYY", "YNNNNYNYYN" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 2;
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