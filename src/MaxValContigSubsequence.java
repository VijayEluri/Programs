import java.util.ArrayList;

public class MaxValContigSubsequence {

	/**
	 * Given a sequence of n real numbers A(1) ... A(n), determine a contiguous subsequence A(i) ... A(j) for which the sum of elements in the subsequence is maximized.
	 * @uml.property  name="numbers"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.Integer"
	 */
	ArrayList<Integer> numbers;
	/**
	 * @uml.property  name="length"
	 */
	int length;
	/**
	 * @uml.property  name="nos" multiplicity="(0 -1)" dimension="1"
	 */
	Integer[] nos;

	public static void main(String[] args) {
		MaxValContigSubsequence maxValContigSubsequenceInstance = new MaxValContigSubsequence();
		maxValContigSubsequenceInstance.processInput(args);
		System.out.println(maxValContigSubsequenceInstance.getMaxSubsequence());
	}

	public MaxValContigSubsequence() {
		numbers = new ArrayList<Integer>();
		length = 0;
	}

	public void processInput(String[] args) {
		for (String x : args) {
			numbers.add(Integer.parseInt(x));
		}
		this.length = args.length;
		nos = new Integer[length];
		numbers.toArray(nos);
	}

	public int getMaxSubsequence() {
		int[] totalsTillJ = new int[length];
		totalsTillJ[0] = nos[0];
		for (int i = 1; i < length; i++) {
			totalsTillJ[i] = Math.max(totalsTillJ[i - 1] + nos[i], nos[i]);
		}
		int max = Integer.MIN_VALUE;
		for (int x : totalsTillJ)
			if (max < x)
				max = x;
		return max;
	}
}
