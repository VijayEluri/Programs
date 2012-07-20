/*
ID: kasturisa1
LANG: JAVA
TASK: crypt1
 */
import java.io.*;
import java.util.*;
import java.text.*;

public class crypt1 {
	int noOfValidNos;
	HashSet<Integer> validIntegers;
	int validIntegerArray[];

	public crypt1() {
		noOfValidNos = 0;
		validIntegers = new HashSet<Integer>();
	}

	public void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("crypt1.in"));
		noOfValidNos = Integer.parseInt(br.readLine());
		validIntegerArray = new int[noOfValidNos];
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		int index = 0;
		while (st.hasMoreTokens()) {
			final int temp = Integer.parseInt(st.nextToken());
			validIntegers.add(temp);
			validIntegerArray[index++] = temp;
		}
		
//		System.out.println("Valid digits: " + Arrays.toString(validIntegerArray));		
	}

	public void process() throws IOException {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<noOfValidNos; i++) {
			map.put(Character.forDigit(i, 10), validIntegerArray[i]);
		}
		
		int present[] = new int[5];
		int result = 0;
		NumberFormat nf = new DecimalFormat("00000");
		for(int i=0, n=(int)Math.pow(noOfValidNos, 5); i<n; ++i) {
			final char[] chars = nf.format(Integer.parseInt(Integer.toString(i, noOfValidNos))).toCharArray();
			int index = 0;
			for(Character x : chars) {
				present[index] = map.get(x);
				index++;
			}
			if(checkValid(present)) {
//				System.out.println(Arrays.toString(present));
				result++;
			}
		}
		PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		w.append(Integer.toString(result));
		w.append("\n");
		w.close();
	}

	private boolean checkValid(final int[] set) {
		int top = set[0] * 100 + set[1] * 10 + set[2];
		int bottom = set[3] * 10 + set[4];

		int prod1 = top * set[4];
		int prod2 = top * set[3];

		if ((prod1 / 100) != 0 && (prod1 / 1000) == 0)
			while (prod1 != 0)
				if (validIntegers.contains(prod1 % 10))
					prod1 /= 10;
				else
					return false;
		else
			return false;

		if ((prod2 / 100) != 0 && (prod2 / 1000) == 0)
			while (prod2 != 0)
				if (validIntegers.contains(prod2 % 10))
					prod2 /= 10;
				else
					return false;
		else
			return false;

		int prod = top * bottom;

		if ((prod / 1000) != 0 && (prod / 10000) == 0)
			while (prod != 0)
				if (validIntegers.contains(prod % 10))
					prod /= 10;
				else
					return false;
		else
			return false;

		return true;
	}

	public static void main(String[] args) throws IOException {
		crypt1 c = new crypt1();
		c.readInput();
		c.process();
	}

}
