package algorithms;

import java.util.ArrayList;
/**
 * Requires implementation of Selection algorithm
 * Check out: http://pastebin.com/2Ugf6scM
 * @author sasik
 *
 */
public class FindKSmallest {
	
	public int[] findKSmallest(final int[] array, final int k) {
		SelectionAlgorithm<Integer> s = new SelectionAlgorithm<Integer>();
		Integer[] arr = new Integer[array.length];
		for(int idx = 0, n = array.length; idx < n; ++idx) {
			arr[idx] = array[idx];
		}
		final int kthSmallestElement = s.select(arr, k);
		ArrayList<Integer> output = new ArrayList<Integer>();
		for(int idx = 0, n = array.length; idx < n; ++idx) {
			if(arr[idx] < kthSmallestElement) {
				output.add(arr[idx]);
			}
		}
		final int[] out = new int[output.size()];
		for(int idx = 0, n = out.length; idx < n; ++idx) {
			out[idx] = output.get(idx);
		}
		return out;
	}
}
 

