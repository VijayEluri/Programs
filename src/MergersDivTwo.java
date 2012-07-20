import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class MergersDivTwo
{
	public class CombinationGenerator {

		  private int[] a;
		  private int n;
		  private int r;
		  private BigInteger numLeft;
		  private BigInteger total;

		  //------------
		  // Constructor
		  //------------

		  public CombinationGenerator (int n, int r) {
		    if (r > n) {
		      throw new IllegalArgumentException ();
		    }
		    if (n < 1) {
		      throw new IllegalArgumentException ();
		    }
		    this.n = n;
		    this.r = r;
		    a = new int[r];
		    BigInteger nFact = getFactorial (n);
		    BigInteger rFact = getFactorial (r);
		    BigInteger nminusrFact = getFactorial (n - r);
		    total = nFact.divide (rFact.multiply (nminusrFact));
		    reset ();
		  }

		  //------
		  // Reset
		  //------

		  public void reset () {
		    for (int i = 0; i < a.length; i++) {
		      a[i] = i;
		    }
		    numLeft = new BigInteger (total.toString ());
		  }

		  //------------------------------------------------
		  // Return number of combinations not yet generated
		  //------------------------------------------------

		  public BigInteger getNumLeft () {
		    return numLeft;
		  }

		  //-----------------------------
		  // Are there more combinations?
		  //-----------------------------

		  public boolean hasMore () {
		    return numLeft.compareTo (BigInteger.ZERO) == 1;
		  }

		  //------------------------------------
		  // Return total number of combinations
		  //------------------------------------

		  public BigInteger getTotal () {
		    return total;
		  }

		  //------------------
		  // Compute factorial
		  //------------------

		  private BigInteger getFactorial (int n) {
		    BigInteger fact = BigInteger.ONE;
		    for (int i = n; i > 1; i--) {
		      fact = fact.multiply (new BigInteger (Integer.toString (i)));
		    }
		    return fact;
		  }

		  //--------------------------------------------------------
		  // Generate next combination (algorithm from Rosen p. 286)
		  //--------------------------------------------------------

		  public int[] getNext () {

		    if (numLeft.equals (total)) {
		      numLeft = numLeft.subtract (BigInteger.ONE);
		      return a;
		    }

		    int i = r - 1;
		    while (a[i] == n - r + i) {
		      i--;
		    }
		    a[i] = a[i] + 1;
		    for (int j = i + 1; j < r; j++) {
		      a[j] = a[i] + j - i;
		    }

		    numLeft = numLeft.subtract (BigInteger.ONE);
		    return a;

		  }
		}

	
	public double findMaximum(int[] revenues, int k)
	{
		return 0d;
	}
	
	public static void main(String[] args)
	{
		long time;
		double answer;
		boolean errors = false;
		double desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new MergersDivTwo().findMaximum(new int[]{5, -7, 3}, 2);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1.5D;
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
		answer = new MergersDivTwo().findMaximum(new int[]{5, -7, 3}, 3);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 0.3333333333333333D;
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
		answer = new MergersDivTwo().findMaximum(new int[]{1, 2, 2, 3, -10, 7}, 3);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 2.9166666666666665D;
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
		answer = new MergersDivTwo().findMaximum(new int[]{-100, -100, -100, -100, -100, 100}, 4);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = -66.66666666666667D;
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
		answer = new MergersDivTwo().findMaximum(new int[]{869, 857, -938, -290, 79, -901, 32, -907, 256, -167, 510, -965, -826, 808, 890, -233, -881, 255, -709, 506, 334, -184, 726, -406, 204, -912, 325, -445, 440, -368}, 7);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 706.0369290573373D;
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