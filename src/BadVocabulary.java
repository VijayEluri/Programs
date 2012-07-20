
public class BadVocabulary {
	public int count(String badPrefix, String badSuffix, String badSubstring,
			String[] vocabulary) {
		int result = 0;
		for (int i = 0, n = vocabulary.length; i < n; i++) {
			if (vocabulary[i].startsWith(badPrefix)
					|| vocabulary[i].endsWith(badSuffix)) {
				System.out.println("Prefix/Suffix match: " + vocabulary[i]);
				result++;
			} else if (vocabulary[i].length() > 2
					&& vocabulary[i].substring(1, vocabulary[i].length() - 1)
							.indexOf(badSubstring) != -1) {
				result++;
				System.out.println("Middle match: " + vocabulary[i]);
			}
		}
		return result;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0,
			String p1, String p2, String[] p3, boolean hasAnswer, int p4) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + ","
				+ "\"" + p1 + "\"" + "," + "\"" + p2 + "\"" + "," + "{");
		for (int i = 0; p3.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p3[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		BadVocabulary obj;
		int answer;
		obj = new BadVocabulary();
		long startTime = System.currentTimeMillis();
		answer = obj.count(p0, p1, p2, p3);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0
				+ " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p4);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p4;
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
		} else if ((endTime - startTime) / 1000.0 >= 2) {
			System.out.println("FAIL the timeout");
			res = false;
		} else if (hasAnswer) {
			System.out.println("Match :-)");
		} else {
			System.out.println("OK, but is it right?");
		}
		System.out.println("");
		return res;
	}

	public static void main(String[] args) {
		boolean all_right;
		all_right = true;

		String p0;
		String p1;
		String p2;
		String[] p3;
		int p4;

		// ----- test 0 -----
		p0 = "bug";
		p1 = "bug";
		p2 = "bug";
		p3 = new String[] { "buggy", "debugger", "debug" };
		p4 = 3;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4)
				&& all_right;
		// ------------------

		// ----- test 1 -----
		p0 = "a";
		p1 = "b";
		p2 = "c";
		p3 = new String[] { "a", "b", "tco" };
		p4 = 3;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4)
				&& all_right;
		// ------------------

		// ----- test 2 -----
		p0 = "cut";
		p1 = "sore";
		p2 = "scar";
		p3 = new String[] { "scary", "oscar" };
		p4 = 0;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4)
				&& all_right;
		// ------------------

		// ----- test 3 -----
		p0 = "bar";
		p1 = "else";
		p2 = "foo";
		p3 = new String[] { "foofoofoo", "foobar", "elsewhere" };
		p4 = 1;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4)
				&& all_right;
		// ------------------

		// ----- test 4 -----
		p0 = "pre";
		p1 = "s";
		p2 = "all";
		p3 = new String[] { "all", "coders", "be", "prepared", "for", "the",
				"challenge", "phase" };
		p4 = 3;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, true, p4)
				&& all_right;
		// ------------------

		if (all_right) {
			System.out
					.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}
// Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!