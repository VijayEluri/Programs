/* http://www.codechef.com/problems/FCTRL/ */

import java.util.Scanner;

public class Fact {
	public int Run() {
		Scanner s = new Scanner(System.in);
		int numberOfTestCases = s.nextInt();
		long testCase = 0;
		int result = 0;
		for (int i = 0; i < numberOfTestCases; i++) {
			testCase = s.nextLong();
			result = 0;
			while (testCase != 0) {
				result += testCase / 5;
				testCase = testCase / 5;
			}			
			System.out.println(result);
		}
		return 0;
	}
}
