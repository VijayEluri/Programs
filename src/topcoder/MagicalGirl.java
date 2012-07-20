package topcoder;

import java.util.Arrays;

public class MagicalGirl
{
	public double maxExpectation(int M, int[] day, int[] win, int[] gain)
	{
		// Sort days, win, gain based on days
		final int numDays = day.length;
		int temp = 0;
		for(int i=0; i<numDays-1; ++i) {
			for(int j=i+1; j<numDays; ++j) {
				if(day[i] > day[j]) {	
					temp = day[i];
					day[i] = day[j];
					day[j] = temp;
					
					temp = win[i];
					win[i] = win[j];
					win[j] = temp;
					
					temp = gain[i];
					gain[i] = gain[j];
					gain[j] = temp;					
				}
			}
		}
		
		System.out.println("Days: " + Arrays.toString(day));
		System.out.println("Win: " +  Arrays.toString(win));
		System.out.println("Gain: " +  Arrays.toString(gain));
		
		double res = 0d;
		int startIdx = 0, endIdx = 0;
		int Mafter = M, actualDay = day[0];
		int prevDay = 0;
		for(int i=0; i<numDays; ++i) {			
			startIdx = i; endIdx = i;
			while(endIdx < numDays && day[endIdx] == day[startIdx]) {
				++endIdx;
			}
			Mafter = Mafter - day[i] - prevDay;			
			prevDay = day[i];

			if(Mafter == 0) {
				return res;
			}
			final Temp result = expOfDay(win, gain, startIdx, endIdx, Mafter, M, actualDay);
			res += result.prob;
			Mafter = result.Mafter;
			actualDay = result.actualDay;
			System.out.println("Day - " + day[i] + " prob = " + res);
			i = endIdx;
		}
		return res;
	}
	
	private class Temp {
		public double prob;
		public int Mafter;
		public int actualDay;
		
		public Temp() {
			prob = 0;
			Mafter = 0;
			actualDay = 0;
		}
	}
	
	public Temp expOfDay(int[] win, int[] gain, int startIdx, int endIdx, int remainingLife, int maxLife, int actualDay) {
		Temp result = new Temp();
		double res = 0d;
		final int numDays = win.length;
		double[] winProb = new double[numDays];
		int[] life = new int[numDays];
		int[] actualDays = new int[numDays];
		actualDays[0] = actualDay;
		for(int i=startIdx; i<endIdx; ++i) {
			if(win[i - startIdx] == 0) {
				winProb[i - startIdx] = 0;
			} else {
				if(i!=startIdx) {
					final double cumulativeProbOfWinningThisMatch = winProb[i - 1 - startIdx] * (0.01d * win[i - startIdx]);
					winProb[i - startIdx] = cumulativeProbOfWinningThisMatch;
					final int lifePointsAfterThisMatchIfWon = Math.min(maxLife, life[i- 1 - startIdx] + gain[i - startIdx]);
					life[i-startIdx] = lifePointsAfterThisMatchIfWon;
					final int deathDayAfterThisMatch = actualDays[i - startIdx] + lifePointsAfterThisMatchIfWon; 
					actualDays[i - startIdx] = deathDayAfterThisMatch;
					res += cumulativeProbOfWinningThisMatch * deathDayAfterThisMatch;	// Winning
					res += (1d - 0.01d * win[i - startIdx]) *  winProb[i- 1 - startIdx] * actualDays[i - 1 - startIdx]; // Losing today
				} else { 
					winProb[i - startIdx] = 0.01d * win[i - startIdx];
					life[i - startIdx] = Math.min(maxLife, remainingLife + gain[i - startIdx]);
					actualDays[i - startIdx] = actualDays[i - startIdx] + life[i - startIdx];
					res += winProb[i - startIdx] * actualDays[i - startIdx] + (1d - winProb[i - startIdx]) * actualDay;					
				}
			}
		}
		result.prob = res;
		result.Mafter = life[numDays-1];
		result.actualDay = actualDays[numDays - 1];
		return result;		
	}
	
	public static void main(String[] args)
	{
		long time;
		double answer;
		boolean errors = false;
		double desiredAnswer;
		
		time = System.currentTimeMillis();
		answer = new MagicalGirl().maxExpectation(2, new int[]{1}, new int[]{75}, new int[]{1});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 2.5D;
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
		answer = new MagicalGirl().maxExpectation(10, new int[]{5,5,5,5}, new int[]{100,100,100,100}, new int[]{1,1,1,1});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 14.0D;
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
		answer = new MagicalGirl().maxExpectation(10, new int[]{5,5,5,5,5}, new int[]{40,80,60,20,0}, new int[]{10,10,10,10,10});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 13.0D;
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
		answer = new MagicalGirl().maxExpectation(2, new int[]{2}, new int[]{100}, new int[]{2});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 2.0D;
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
		answer = new MagicalGirl().maxExpectation(20, new int[]{2,13,8,7,9,4,6,21}, new int[]{18,83,75,23,45,23,10,98}, new int[]{10,9,8,10,7,16,13,20});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 35.908D;
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
		answer = new MagicalGirl().maxExpectation(11, new int[]{10,20,30,40,50,60,70,80,90}, new int[]{100,100,100,100,100,100,100,100,100}, new int[]{10,10,10,10,10,10,10,10,10});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 101.0D;
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
		answer = new MagicalGirl().maxExpectation(100000, new int[]{1000000}, new int[]{100}, new int[]{100000});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 100000.0D;
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
//Powered by [KawigiEdit] 2.0!