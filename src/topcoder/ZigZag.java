//Problem statement: http://community.topcoder.com/tc?module=ProblemDetail&rd=4493&pm=1259
package topcoder;

import java.util.ArrayList;

public class ZigZag {
	public int longestZigZag(int[] sequence) {
		// Version 2
		// Store differences and choose the sequence of flipping differences
		if(sequence.length == 1) 
			return 1;
		
		ArrayList<Integer> differences = new ArrayList<Integer>(sequence.length - 1);
		for(int i = 1; i < sequence.length; ++i) {
			differences.add(sequence[i] - sequence[i-1]); 
		}
		
		// Start at the first non-zero difference
		int start = 0;
		while(differences.get(start) == 0) ++start;
		
		int difference = differences.get(start);
		int result = 2;
		for(int next = start + 1; next < sequence.length - 1; ++next) {
			if( difference * differences.get(next) < 0 ) {
				++ result;
				difference *= -1;
			}
		}
		
		return result;
		// Version 1 - O(n^2)
//		if(sequence.length < 2) {
//			return 1; 
//		}
//		int[] dptable = new int[sequence.length];
//		boolean[] sign = new boolean[sequence.length];
//		int[] bestIdx = new int[sequence.length];
//		for(int i=0; i < bestIdx.length; ++i) bestIdx[i] = i;
//		bestIdx[0] = -1; bestIdx[1] = 1;
//		Arrays.fill(sign, false);
//		sign[0] = true;
//		sign[1] = sequence[1] - sequence[0] > 0 ? true : false; 
//		Arrays.fill(dptable, 0);
//		dptable[0] = 1;	dptable[1] = 2;
//		for(int i = 1; i < sequence.length; ++i) {
//			int maxState = Integer.MIN_VALUE;
//			boolean maxSign = false;
//			int best = -1;
//			for(int j = 0; j < i; ++j) {
//				if(sequence[i] == sequence[j]) continue;
//				final boolean jiSign = sequence[i] - sequence[j] > 0 ? false : true;
//				if((j == 0) || jiSign ^ sign[j]) {
//					if(maxState < (dptable[j] + 1)) {
//						maxState = dptable[j] + 1;
//						maxSign = jiSign;
//						best = j;
//					}
//				}
//			}
//			dptable[i] = maxState;
//			sign[i] = maxSign;
//			bestIdx[i] = best;
////			System.out.println(Arrays.toString(dptable));
//		}
//		int max = Integer.MIN_VALUE;
//		int maxIdx = -1;
//		for(int i=0; i<dptable.length; ++i) {
//			if(max < dptable[i]) {
//				maxIdx = i;
//				max = dptable[i];
//			}
//		}
//
////		// Sequence
////		while(maxIdx != -1) {
////			System.out.print(sequence[maxIdx] + "\t");
////			maxIdx = bestIdx[maxIdx];
////		}
//		
//		return max;
	}

	public static void main(String[] args) {
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;

		time = System.currentTimeMillis();
		answer = new ZigZag().longestZigZag(new int[] { 1, 7, 4, 9, 2, 5 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 6;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ZigZag().longestZigZag(new int[] { 1, 17, 5, 10, 13, 15,
				10, 5, 16, 8 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 7;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ZigZag().longestZigZag(new int[] { 44 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 1;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ZigZag().longestZigZag(new int[] { 1, 2, 3, 4, 5, 6, 7, 8,
				9 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 2;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ZigZag().longestZigZag(new int[] { 70, 55, 13, 2, 99, 2,
				80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 8;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new ZigZag().longestZigZag(new int[] { 374, 40, 854, 203, 203,
				156, 362, 279, 812, 955, 600, 947, 978, 46, 100, 953, 670, 862,
				568, 188, 67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 477,
				245, 413, 109, 659, 401, 483, 308, 609, 120, 249, 22, 176, 279,
				23, 22, 617, 462, 459, 244 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 36;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();

		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out
					.println("You're a stud (at least on the test data)! :-D ");
	}

}
