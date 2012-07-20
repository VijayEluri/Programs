/*
 * http://www.codechef.com/problems/DCE05/
The captain of the ship TITANIC is a little .... off the track. He needs to select the crew for the ship. But everyone seems to be eligible. So to test their intelligence, he plays a game.
The contestants have to stand in a line. They are given the numbers in the order in which they stand, starting from 1. The captain then removes all the contestants that are standing at an odd position.
Initially, standing people have numbers - 1,2,3,4,5...
After first pass, people left are - 2,4,...
After second pass - 4,....
And so on.
You want to board the ship as a crew member. Given the total number of applicants for a position, find the best place to stand in the line so that you are selected.
Input

First line contains the number of test cases t (t<=10^6). The next t lines contain integer n, the number of applicants for that case. (n<=10^9)
Output

Display t lines, each containing a single integer, the place where you would stand to win a place at TITANIC.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Odd {
	public static void main(String[] args) {
		int noOfTestCases = 0;
		
		int testCase = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			noOfTestCases = Integer.parseInt(reader.readLine().trim());
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		boolean doneFlag = false;
		for (int l = 0; l < noOfTestCases; l++) {
			try {
				testCase = Integer.parseInt(reader.readLine().trim());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boolean valid[] = new boolean[testCase];
			int nos[] = new int[testCase];
			for (int i = 0; i < testCase; i++) {
				nos[i] = i + 1;
				valid[i] = true;
			}

			int noOfValid = testCase;
			boolean toRemoveThisNumber = true;
			while (true) {
				toRemoveThisNumber = true;
				for (int i = 0; i < testCase; i++) {
					if (valid[i]) {
						if (toRemoveThisNumber) {
							valid[i] = false;
							noOfValid--;
						}
						toRemoveThisNumber = !toRemoveThisNumber;
					}
					if (noOfValid == 1) {
						for (int j = 0;j<testCase;j++) {
							if (valid[j] == true) {
								System.out.println(nos[j]);
								doneFlag = true;
								break;
							}
						}
						if (doneFlag)
							break;
					}
				}
				if (doneFlag) {
					doneFlag = false;
					break;
				}

			}
		}
	}
}
