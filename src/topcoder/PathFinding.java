package topcoder;

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class PathFinding {
	private class Node {
		int P1X, P1Y, P2X, P2Y;
		int numSteps = 0;
		Node(int p1X, int p1Y, int p2X, int p2Y) {
			P1X = p1X;
			P1Y = p1Y;
			P2X = p2X;
			P2Y = p2Y;
		}
		
		public void setNumSteps(int numSteps) {
			this.numSteps = numSteps;
		}
		
		public void setP1(int p1X, int p1Y) {
			P1X = p1X;
			P1Y = p1Y;
		}
		
		public void setP2(int p2X, int p2Y) {
			P2X = p2X;
			P2Y = p2Y;
		}
	}
	
	boolean [][][][]visited;
	
	public int minTurns(String[] board) {
		final int numRows = board.length;
		final int numCols = board[0].toCharArray().length;
		visited = new boolean[numRows][numCols][numRows][numCols];
		for(int i=0; i<numRows; ++i) {
			for(int j=0; j<numCols; ++j) {
				for(int k=0; k<numRows; ++k) {
					for(int m=0; m<numCols; ++m) {
						visited[i][j][k][m] = false;
					}
				}
			}
		}
		
		Node start = new Node(0, 0, 0, 0);
		for(int i=0; i<board.length; ++i) {
			if(board[i].indexOf('A') != -1) {
				start.setP1(i, board[i].indexOf('A'));
			}
			
			if (board[i].indexOf("B") != -1) {
				start.setP1(i, board[i].indexOf('B'));
			}	
			
			for(int j=0; j<board[i].length(); ++j) {
				if(board[i].charAt(j) == 'X') {
					
				}
			}
		}
		
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(start);
		while(!queue.isEmpty()) {
			final Node top = queue.removeFirst();
			
			if (top.P1X == start.P2X && top.P1Y == start.P2Y && start.P2X == top.P1X && start.P2Y == top.P1Y) {
				return top.numSteps;
			}
			
			for(int p1XDelta = -1; p1XDelta < 2; ++p1XDelta) {
				for(int p1YDelta = -1; p1YDelta < 2; ++p1YDelta) {
					for(int p2XDelta = -1; p2XDelta < 2; ++p2XDelta) {
						for(int p2YDelta = -1; p2YDelta < 2; ++p2YDelta) {
							if(p1XDelta < 0 || p1XDelta > numRows - 1 || p2XDelta < 0 || p2XDelta > numRows - 1 || 
									p1YDelta < 0 || p1YDelta > numCols - 1 || p2YDelta > 0 || p2YDelta > numCols - 1) {
								continue;
							}
		
							// Do not cross
							
						}	
					}
					
				}
			}
		}
		return 0;
	}

	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		time = System.currentTimeMillis();
		answer = new PathFinding().minTurns(new String[]{"....", ".A..", "..B.", "...."});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 2;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new PathFinding().minTurns(new String[]{"XXXXXXXXX", "A...X...B", "XXXXXXXXX"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = -1;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new PathFinding().minTurns(new String[]{"XXXXXXXXX", "A.......B", "XXXXXXXXX"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = -1;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new PathFinding().minTurns(new String[]{"XXXXXXXXX", "A.......B", "XXXX.XXXX"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 8;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new PathFinding().minTurns(new String[]{"...A.XXXXX.....", ".....XXXXX.....", "...............", ".....XXXXX.B...", ".....XXXXX....."});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 13;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new PathFinding().minTurns(new String[]{"AB.................X", "XXXXXXXXXXXXXXXXXXX.", "X..................X", ".XXXXXXXXXXXXXXXXXXX", "X..................X", "XXXXXXXXXXXXXXXXXXX.", "X..................X", ".XXXXXXXXXXXXXXXXXXX", "X..................X", "XXXXXXXXXXXXXXXXXXX.", "X..................X", ".XXXXXXXXXXXXXXXXXXX", "X..................X", "XXXXXXXXXXXXXXXXXXX.", "X..................X", ".XXXXXXXXXXXXXXXXXXX", "X..................X", "XXXXXXXXXXXXXXXXXXX.", "...................X", ".XXXXXXXXXXXXXXXXXXX"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 379;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}
}
// Powered by [KawigiEdit] 2.0!