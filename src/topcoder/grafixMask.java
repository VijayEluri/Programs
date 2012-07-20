package topcoder;

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class grafixMask {
	final int totalRows = 400, totalColumns = 600;

	public int[] sortedAreas(String[] rectangles) {
		final int totalRows = 400, totalColumns = 600;
		final boolean blocked[][] = new boolean[totalRows][totalColumns];
		for (int i = 0; i < totalRows; ++i) {
			for (int j = 0; j < totalColumns; ++j) {
				blocked[i][j] = false;
			}
		}

		StringTokenizer st = null;
		for (String rect : rectangles) {
			st = new StringTokenizer(rect);
			final int startRow = Integer.parseInt(st.nextToken());
			final int startCol = Integer.parseInt(st.nextToken());
			final int endRow = Integer.parseInt(st.nextToken());
			final int endCol = Integer.parseInt(st.nextToken());
			for(int i=startRow; i <= endRow; ++i) {
				for(int j=startCol; j <= endCol; ++j) {
					blocked[i][j] = true;
				}
			}
		}

		ArrayList<Integer> areas = new ArrayList<Integer>();
		boolean stillMore = true;
		while (stillMore) {
			int row = -1, col = -1;
			stillMore = false;
			for (int i = 0; i < totalRows; ++i) {
				for (int j = 0; j < totalColumns; ++j) {
					if (!blocked[i][j]) {
						stillMore = true;
						blocked[i][j] = true;
						row = i;
						col = j;
					}
					if (row != -1)
						break;
				}
				if (row != -1)
					break;
			}

			if (row != -1) {
				// Do DFS and find area
				areas.add(doDFS(row, col, blocked));
			}
		}
		final int[] sol = new int[areas.size()];
		for (int i = 0; i < areas.size(); ++i) {
			sol[i] = areas.get(i);
		}
		Arrays.sort(sol);
		return sol;
	}

	private int doDFS(final int row, final int col, final boolean[][] blocked) {
		LinkedList<Integer> rows = new LinkedList<Integer>();
		LinkedList<Integer> cols = new LinkedList<Integer>();
		rows.add(row);
		cols.add(col);

		int area = 0;
		while (!rows.isEmpty()) {
			final int presentRow = rows.removeFirst();
			final int presentCol = cols.removeFirst();
			blocked[presentRow][presentCol] = true;
			++area;
			// Check all the neighbourhood of presentRow, Col

			if (valid(presentRow - 1, presentCol) && !blocked[presentRow - 1][presentCol]) {
				blocked[presentRow - 1][presentCol] = true;
				rows.add(presentRow - 1);
				cols.add(presentCol);
			}

			if (valid(presentRow, presentCol - 1) && !blocked[presentRow][presentCol - 1]) {
				blocked[presentRow][presentCol - 1] = true;
				rows.add(presentRow);
				cols.add(presentCol - 1);
			}

			if (valid(presentRow + 1, presentCol) && !blocked[presentRow + 1][presentCol]) {
				blocked[presentRow + 1][presentCol] = true;
				rows.add(presentRow + 1);
				cols.add(presentCol);
			}

			if (valid(presentRow, presentCol + 1) && !blocked[presentRow][presentCol + 1]) {
				blocked[presentRow][presentCol + 1] = true;
				rows.add(presentRow);
				cols.add(presentCol + 1);
			}
		}
		return area;
	}

	private boolean valid(final int row, final int col) {
		if (row > -1 && row < totalRows && col > -1 && col < totalColumns) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		long time;
		int[] answer;
		boolean errors = false;
		int[] desiredAnswer;

		boolean same;

		time = System.currentTimeMillis();
		answer = new grafixMask().sortedAreas(new String[] { "0 292 399 307" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new int[] { 116800, 116800 };
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ " + answer[0]);
			for (int i = 1; i < answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new grafixMask().sortedAreas(new String[] { "48 192 351 207",
				"48 392 351 407", "120 52 135 547", "260 52 275 547" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new int[] { 22816, 192608 };
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ " + answer[0]);
			for (int i = 1; i < answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new grafixMask().sortedAreas(new String[] { "0 192 399 207",
				"0 392 399 407", "120 0 135 599", "260 0 275 599" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new int[] { 22080, 22816, 22816, 23040, 23040, 23808,
				23808, 23808, 23808 };
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ " + answer[0]);
			for (int i = 1; i < answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new grafixMask().sortedAreas(new String[] { "50 300 199 300",
				"201 300 350 300", "200 50 200 299", "200 301 200 550" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new int[] { 1, 239199 };
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ " + answer[0]);
			for (int i = 1; i < answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new grafixMask().sortedAreas(new String[] { "0 20 399 20",
				"0 44 399 44", "0 68 399 68", "0 92 399 92", "0 116 399 116",
				"0 140 399 140", "0 164 399 164", "0 188 399 188",
				"0 212 399 212", "0 236 399 236", "0 260 399 260",
				"0 284 399 284", "0 308 399 308", "0 332 399 332",
				"0 356 399 356", "0 380 399 380", "0 404 399 404",
				"0 428 399 428", "0 452 399 452", "0 476 399 476",
				"0 500 399 500", "0 524 399 524", "0 548 399 548",
				"0 572 399 572", "0 596 399 596", "5 0 5 599", "21 0 21 599",
				"37 0 37 599", "53 0 53 599", "69 0 69 599", "85 0 85 599",
				"101 0 101 599", "117 0 117 599", "133 0 133 599",
				"149 0 149 599", "165 0 165 599", "181 0 181 599",
				"197 0 197 599", "213 0 213 599", "229 0 229 599",
				"245 0 245 599", "261 0 261 599", "277 0 277 599",
				"293 0 293 599", "309 0 309 599", "325 0 325 599",
				"341 0 341 599", "357 0 357 599", "373 0 373 599",
				"389 0 389 599" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new int[] { 15, 30, 45, 45, 45, 45, 45, 45, 45, 45, 45,
				45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45,
				100, 115, 115, 115, 115, 115, 115, 115, 115, 115, 115, 115,
				115, 115, 115, 115, 115, 115, 115, 115, 115, 115, 115, 115,
				115, 200, 230, 230, 230, 230, 230, 230, 230, 230, 230, 230,
				230, 230, 230, 230, 230, 230, 230, 230, 230, 230, 230, 230,
				230, 230, 300, 300, 300, 300, 300, 300, 300, 300, 300, 300,
				300, 300, 300, 300, 300, 300, 300, 300, 300, 300, 300, 300,
				300, 300, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345, 345,
				345, 345 };
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ " + answer[0]);
			for (int i = 1; i < answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same) {
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