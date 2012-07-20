package mycareerstack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class ReversePolishNotation {
	public static void main(String[] args) throws Exception {
		ReversePolishNotation r = new ReversePolishNotation();
		r.run();
	}
	
	public void run() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int numTestCases = Integer.parseInt(reader.readLine().trim());
		for(int i=0; i<numTestCases; ++i) {
			StringBuilder sb = new StringBuilder();
			final char[] arr = reader.readLine().trim().toCharArray();
			Stack<Character> s = new Stack<Character>();
			for(char c : arr) {
				switch (c) {
				case '*': case '+': case '/': case '-': case '^':
					s.push(c);
					break;
				case ')':
					sb.append(s.pop());
					break;
				case '(':
					break;
				default: 
					sb.append(c);
					break;						
				}					
			}
			System.out.println(sb.toString());
		}
	}
}
