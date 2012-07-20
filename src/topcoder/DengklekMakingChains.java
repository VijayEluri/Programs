package topcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class DengklekMakingChains {
	public int maxBeauty(String[] chains) {
		ArrayList<String> cantBeMixed = new ArrayList<String>();
		int fullValue = 0, midValue = 0;
		final String fullRegex = "[0-9]{3}", midRegex = "\\.[0-9]\\.", nullRegex = "[\\.]{3}";
		for (String link : chains) {
			if (link.matches(fullRegex)) {
				for (char c : link.toCharArray()) {
					fullValue += c - '0';
				}
			} else if (link.matches(midRegex)) {
				midValue = Math.max(midValue, link.charAt(1) - '0');
			} else if (!link.matches(nullRegex)) {
				cantBeMixed.add(link);
			}
		}
		final int size = cantBeMixed.size();
		int[][] graph = new int[size][size];
		for (int i = 0; i < size; ++i) {
			Arrays.fill(graph[i], 1);
		}

		int max = 0;
		if (size == 1) {
			final String s = cantBeMixed.get(0);
			if (s.matches("[0-9]\\.[0-9]")) {
				max = Math.max(s.charAt(0), s.charAt(2)) - '0';
			}
			if (s.matches("[0-9]{2}\\.")) {
				max = s.charAt(1) + s.charAt(0) - 2 * '0';
			}
			if (s.matches("\\.[0-9]{2}")) {
				max = s.charAt(1) + s.charAt(2) - 2 * '0';
			}
			if (s.matches("[0-9][\\.]{2}")) {
				max = s.charAt(0) - '0';
			}
			if (s.matches("[\\.]{2}[0-9]")) {
				max = s.charAt(2) - '0';
			}
			if (s.matches("\\.[0-9]\\.")) {
				max = s.charAt(1) - '0';
			}
			if (s.matches("[0-9]{3}")) {
				max = s.charAt(0) + s.charAt(1) + s.charAt(2) - 3 * '0';
			}
		}

		for (int i = 0, n = size; i < n - 1; ++i) {
			for (int j = i + 1; j < n; ++j) {
				final String a = cantBeMixed.get(i), b = cantBeMixed.get(j);

				final String ab = a.concat(b);
				final int valAb = getValueOfConcatenatedString(ab);
				final String ba = b.concat(a);
				final int valBa = getValueOfConcatenatedString(ba);

				if (valAb != -1) {
					max = Math.max(valAb, max);
				}
				if (valBa != -1) {
					max = Math.max(valBa, max);
				}
			}
		}
		return Math.max(Math.max(max + fullValue, midValue), 0);
	}

	private int getValueOfConcatenatedString(final String a) {
		int value = 0;
		if (a.charAt(2) != '.' && a.charAt(3) != '.') {
			value += a.charAt(2) - '0' + a.charAt(3) - '0';
			value += a.charAt(1) != '.' ? a.charAt(1) - '0' : 0;
			value += a.charAt(4) != '.' ? a.charAt(4) - '0' : 0;
			return value;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;

		time = System.currentTimeMillis();
		answer = new DengklekMakingChains().maxBeauty(new String[] { ".15",
				"7..", "402", "..3" });
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
		answer = new DengklekMakingChains().maxBeauty(new String[] { "..1",
				"7..", "567", "24.", "8..", "234" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 36;
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
		answer = new DengklekMakingChains().maxBeauty(new String[] { "...",
				"..." });
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
		answer = new DengklekMakingChains().maxBeauty(new String[] { "16.",
				"9.8", ".24", "52.", "3.1", "532", "4.4", "111" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 28;
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
		answer = new DengklekMakingChains().maxBeauty(new String[] { "..1",
				"3..", "2..", ".7." });
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
		answer = new DengklekMakingChains().maxBeauty(new String[] { "412",
				"..7", ".58", "7.8", "32.", "6..", "351", "3.9", "985", "...",
				".46" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 58;
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