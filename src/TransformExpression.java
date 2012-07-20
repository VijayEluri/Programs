import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class TransformExpression {
	public void run() {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(
				System.in));
		ArrayList<String> inputLines = new ArrayList<String>();

		try {
			int noOfTestCases = Integer.parseInt(inputReader.readLine());
			for (int i = 0; i < noOfTestCases; ++i) {
				inputLines.add(inputReader.readLine());
			}
			process(inputLines.toArray());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void process(Object[] inputLines) {
		Stack<Character> st = new Stack<Character>();
		char ele;
		String present;
		for (int i = 0, n = inputLines.length; i < n; ++i) {
			present = (String) inputLines[i];
			st.clear();
			for (int j = 0, l = present.length(); j < l; j++) {
				ele = present.charAt(j);
				switch (ele) {
				case '+':
				case '*':
				case '-':
				case '/':
				case '^':
				case '(':
					st.push(ele);
					break;
				case ')':
					while (st.peek() != '(') {
						System.out.print(st.pop());
					}
					st.pop();
					break;
				default:
					System.out.print(ele);
				}

			}
			while (!st.empty())
				System.out.print(st.pop());
			System.out.print('\n');
		}
	}
}
