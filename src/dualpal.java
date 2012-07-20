

import java.util.*;
import java.io.*;

public class dualpal {
	/**
	 * @uml.property  name="n"
	 */
	private int N;
	/**
	 * @uml.property  name="s"
	 */
	private int S;

	public boolean isPalindrome(String s) {
		final int l = s.length();
		if (l == 1)
			return true;
		final char[] sArr = s.toCharArray();
		for (int i = 0; i < (l / 2); ++i) {
			if (sArr[i] != sArr[l - i - 1])
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		dualpal dp = new dualpal();
		dp.readInput();
		dp.process();
	}

	public void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("dualpal.in"));
		final StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());		
	}

	public void process() throws IOException {
		int count = 0, present = S + 1;
		PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		while (count < N) {
			if(countPalindrome(present) >= 2 ) {
				++count;
				//System.out.println(present);
				w.append(present + "\n");
			}
			present++;			
		}
		w.close();
	}

	private int countPalindrome(int n) {
		int count = 0;
		for (int i = 2; i <= 10; i++) {
			if (isPalindrome(Integer.toString(n, i)))
				count++;
		}
		return count;
	}

}
