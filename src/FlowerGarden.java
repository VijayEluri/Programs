import java.util.Arrays;

public class FlowerGarden {
	public int[] getOrdering(int[] height, int[] bloom, int[] wilt) {
		final int numFlowerTypes = height.length;
		final int[] ret = new int[numFlowerTypes];
		Arrays.fill(ret, 0);
		final boolean used[] = new boolean[numFlowerTypes];
		Arrays.fill(used, false);
		
		for(int i = 0; i < numFlowerTypes; ++i) {
			int bestIdx = -1;
			for(int j=0; j < numFlowerTypes; ++j) {
				if(!used[j]) {
					boolean isPresentFlowerInsertable = true;
					for(int k = 0; k < numFlowerTypes; ++k) {
						if(k != j && !used[k] && height[k] < height[j] && wilt[k] >= bloom[j] && bloom[k] <= wilt[j]) {
							isPresentFlowerInsertable = false;
						}	
					}	
					if(isPresentFlowerInsertable && (bestIdx == -1 || height[j] > height[bestIdx])) { 
						bestIdx = j;
					}
				}
			}
			ret[i] = height[bestIdx];
			used[bestIdx] = true;
		}
		return ret;
	}

	public static void main(String[] args) {
		long time;
		int[] answer;
		boolean errors = false;
		int[] desiredAnswer;

		boolean same;
		time = System.currentTimeMillis();
		answer = new FlowerGarden().getOrdering(new int[] { 5, 4, 3, 2, 1 },
				new int[] { 1, 1, 1, 1, 1 }, new int[] { 365, 365, 365, 365,
						365 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new int[] { 1, 2, 3, 4, 5 };
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ " + answer[0]);
			for (int i = 1; i < answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new FlowerGarden().getOrdering(new int[] { 5, 4, 3, 2, 1 },
				new int[] { 1, 5, 10, 15, 20 }, new int[] { 4, 9, 14, 19, 24 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new int[] { 5, 4, 3, 2, 1 };
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ " + answer[0]);
			for (int i = 1; i < answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new FlowerGarden()
				.getOrdering(new int[] { 5, 4, 3, 2, 1 }, new int[] { 1, 5, 10,
						15, 20 }, new int[] { 5, 10, 15, 20, 25 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new int[] { 1, 2, 3, 4, 5 };
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ " + answer[0]);
			for (int i = 1; i < answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new FlowerGarden()
				.getOrdering(new int[] { 5, 4, 3, 2, 1 }, new int[] { 1, 5, 10,
						15, 20 }, new int[] { 5, 10, 14, 20, 25 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new int[] { 3, 4, 5, 1, 2 };
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ " + answer[0]);
			for (int i = 1; i < answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new FlowerGarden().getOrdering(new int[] { 1, 2, 3, 4, 5, 6 },
				new int[] { 1, 3, 1, 3, 1, 3 }, new int[] { 2, 4, 2, 4, 2, 4 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new int[] { 2, 4, 6, 1, 3, 5 };
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ " + answer[0]);
			for (int i = 1; i < answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new FlowerGarden().getOrdering(new int[] { 3, 2, 5, 4 },
				new int[] { 1, 2, 11, 10 }, new int[] { 4, 3, 12, 13 });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new int[] { 4, 5, 2, 3 };
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ " + answer[0]);
			for (int i = 1; i < answer.length; i++)
				System.out.print(", " + answer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ " + desiredAnswer[0]);
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(", " + desiredAnswer[i]);
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (answer[i] != desiredAnswer[i])
				same = false;
		if (!same) {
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
// Powered by [KawigiEdit] 2.0!