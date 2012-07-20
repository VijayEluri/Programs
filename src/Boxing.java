import java.util.*;

public class Boxing {
	public int maxCredit(int[] a, int[] b, int[] c, int[] d, int[] e) {
		final int numArrays = 5;
		int result = 0;
		int bestTime[] = new int[numArrays];
		int hits[][] = new int[numArrays][];
		hits[0] = a;	hits[1] = b;	hits[2] = c;	hits[3] = d;	hits[4] = e;
		Arrays.sort(a);
		for (int i = 0; i < 180000; ++i) {
			for(int j = 0; j < numArrays; ++j) {
				bestTime[j] = getIndex(hits[j], i);	
			}
			Arrays.sort(bestTime);
			if(bestTime[2] <= (i + 1000)) { // Atleast 3 judges and in milliseconds
				++result;
				i = bestTime[2];
			}
			
			// Update time so that we look from the next time
		}
		return result;
	}
	
	int getIndex(int[] arr, int key) {
		int res = Arrays.binarySearch(arr, key);
		if(res < 0) {
			res = - res - 1;
		} 
		if (res < arr.length) {
			return arr[res]; 
		} else {
			return Integer.MAX_VALUE;
		}
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new Boxing().maxCredit(new int[]{1,2,3,4,5,6}, new int[]{1,2,3,4,5,6,7}, new int[]{1,2,3,4,5,6}, new int[]{0,1,2}, new int[]{1,2,3,4,5,6,7,8});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 6;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new Boxing().maxCredit(new int[]{100,200,300,1200,6000}, new int[]{}, new int[]{900,902,1200,4000,5000,6001}, new int[]{0,2000,6002}, new int[]{1,2,3,4,5,6,7,8});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 3;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new Boxing().maxCredit(new int[]{5000,6500}, new int[]{6000}, new int[]{6500}, new int[]{6000}, new int[]{0,5800,6000});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}