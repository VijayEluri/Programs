import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

/**
 * @author sasik 
 * Prob 3 of Infoaxe test Does this in \theta(n) time complexity
 */
public class SubSum {
	/**
	 * @param inputVector
	 *            The array in which subSum of zero mod needs to be found
	 * @return The sub array with zero remainder sum
	 */
	public int[] subSum(Vector<Integer> inputVector) {
		if (inputVector == null) {
			return new int[] {};
		}
		HashMap<Integer, Integer> modToIndex = new HashMap<Integer, Integer>();
		final int arrayLength = inputVector.size();

		if (arrayLength == 0 || arrayLength == 1) {
			return new int[] {}; // return empty array if not found
		}
		// System.out.println("DEBUG: Length of array " + arrayLength);

		int[] result = null;

		int prevMod = 0;
		for (int i = 0; i < arrayLength; ++i) {
			final int element = inputVector.get(i);
			prevMod = (element + prevMod) % arrayLength; // Cumulative mod
			if (modToIndex.containsKey(prevMod)) {
				final int start = modToIndex.get(prevMod);
				final int end = i;
				result = new int[end - start];
				int idx = 0;
				for (int j = (start + 1); j < (end + 1); ++j) {
					result[idx++] = inputVector.get(j);
				}
				break;
			}
			modToIndex.put(prevMod, i);
			// System.out.println("DEBUG: idx " + i + " element " + element + " Mod " + prevMod);
		}

		return result == null ? new int[] {} : result;													
	}

	/**
	 * Test bed
	 */
	public static void main(String[] args) {
		SubSum s = new SubSum();
		Vector<Integer> v = new Vector<Integer>();
		for (int i : new int[] { 20, 15, 42, 33, 30, 67, 12, 62, }) {
			v.add(i);
		}
		System.out.println(Arrays.toString(s.subSum(v)));

		// Null 
		System.out.println(Arrays.toString(s.subSum(null)));
		
		// Empty value
		v.clear();
		System.out.println(Arrays.toString(s.subSum(v)));

		// 1 million values
//		final Random r = new Random(SubSum.class.getCanonicalName().hashCode());
		final Random r = new Random();
		for (int i = 0; i < 1000000; ++i) {
			v.add(r.nextInt());
		}
		
		final long start = System.nanoTime();
		System.out.println(s.subSum(v).length);
		System.out.println("Time taken: " + (System.nanoTime() - start) / Math.pow(10, 9));
	}
}
