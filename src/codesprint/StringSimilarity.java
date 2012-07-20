package codesprint;

import java.util.Scanner;

public class StringSimilarity {
	final int T;
	final String[] testCases;

	public static void main(String[] args) {
		StringSimilarity s = new StringSimilarity();
		s.run();
	}

	public StringSimilarity() {
		final Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		assert T > -1;
		testCases = new String[T];
		for (int i = 0; i < T; ++i) {
			testCases[i] = sc.next();
		}
	}

	public void run() {
		for(int i=0; i<T; ++i) {
			System.out.println(run(testCases[i]));
		}
	}

	private int run(String testCase) {
		final char[] charArr = testCase.toCharArray();
		int result = 0;
		for(int i=0, n=testCase.length(); i<n; ++i) {
			int sim = getSimilarity(charArr, i);
//			System.out.println("String: " + testCase + " Substring: " + testCase.substring(i));
			result += sim;
		}
		return result;
	}
	
	private int getSimilarity(char[] parent, int startPos) {
		assert startPos < parent.length;
		int result = 0;
		for(int i=0, n=parent.length - startPos; i<n; ++i) {
			if(parent[i] != parent[startPos + i]) {
				break;
			}
			++result;
		}
		return result;
	}
}
