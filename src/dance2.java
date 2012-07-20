

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class dance2 {

	public static void main(String[] args) throws IOException {
		// BufferedReader reader = new BufferedReader(new InputStreamReader(
		// System.in));
		BufferedReader reader = new BufferedReader(new FileReader("dance2.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(
				"dance2.out")));

		int noOfTestCases = Integer.parseInt(reader.readLine().trim());
		Stack<Character> s = new Stack<Character>();
		char[] input;
		StringTokenizer st;
		int k = 0;
		boolean flag = true;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < noOfTestCases; i++) {
			flag = true;
			s.empty();

			st = new StringTokenizer(reader.readLine().trim());
			k = Integer.valueOf(st.nextToken());
			input = st.nextToken().toCharArray();

			for (int j = 0; j < k; j++) {
				if (input[j] == '>') {
					s.push('>');
				} else if (input[j] == '<') {
					if (s.isEmpty()) {
						flag = false;
						break;
					} else
						s.pop();
				}
			}

			if (flag && !s.isEmpty())
				flag = false;

			if (flag)
				sb.append("legal\n");
			else
				sb.append("illegal\n");

		}
		// System.out.println(sb.toString());
		writer.write(sb.toString());
		writer.close();
		System.exit(0);

	}

}
