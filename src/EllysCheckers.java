import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class EllysCheckers {
	public String getWinner(String board) {
		final char[] boardArr = board.toCharArray();
		final ArrayList<Integer> initialPossibilities = new ArrayList<Integer>();
		boolean chance = false; // False - Ellys chance
		boolean isPoss = true;
		while (isPoss) {
			isPoss = false;
			for (int i = 0, n = board.length(); i < n; ++i) {
				if (boardArr[i] == 'o') {
					switch (isPossible(boardArr, i)) {
					case 2:
						boardArr[i + 3] = 'o';
						boardArr[i] = '.';
						isPoss = true;
						break;
					case 1:
						boardArr[i + 1] = 'o';
						boardArr[i] = '.';
						isPoss = true;
						break;
					default:
						continue;
					}
				}
				if(isPoss) {
					chance = !chance;
					break;
				}				
			}
		}
		return chance ? "YES" : "NO";
	}

	private int isPossible(final char[] board, final int index) {
		if (index > board.length) {
			return -1;
		}
		if ((index + 3) < board.length && board[index + 1] == 'o'
				&& board[index + 2] == 'o') {
			return 2;
		}
		if (((index + 1) < board.length) && (board[index + 1] == '.')) {
			return 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		long time;
		String answer;
		boolean errors = false;
		String desiredAnswer;

		time = System.currentTimeMillis();
		answer = new EllysCheckers().getWinner(".o...");
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = "YES";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer)) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new EllysCheckers().getWinner("..o..o");
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = "YES";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer)) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new EllysCheckers().getWinner(".o...ooo..oo..");
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = "NO";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer)) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new EllysCheckers().getWinner("......o.ooo.o......");
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = "YES";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer)) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new EllysCheckers().getWinner(".o..o...o....o.....o");
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = "NO";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer)) {
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