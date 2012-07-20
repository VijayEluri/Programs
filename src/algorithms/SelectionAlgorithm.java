package algorithms;

import java.util.*;

/**
 * 
 * Find kth smallest element in an array
 * Randomized algorithm
 * @author sasik
 * Credits: http://pine.cs.yale.edu/pinewiki/QuickSelect
 */

public class SelectionAlgorithm<T extends Comparable<T>> {
	Random r = new Random(SelectionAlgorithm.class.hashCode());
	
	/**
	 * Finds the kth smallest element in the array in O(n) time
	 * Randomized algorithm
	 * @param array Unsorted array of elements 
	 * @param k	
	 * @return kth smallest element array
	 */
	public T select(final T[] array, final int k) {
		ArrayList<T> A1 = new ArrayList<T>(), A2 = new ArrayList<T>(), A = new ArrayList<T>(Arrays.asList(array));
		int size = -1;
		int searchK = k;
		while(true) {
			A1.clear();
			A2.clear();	
			size = A.size();
			
			final int pivotIdx = r.nextInt(size);
			final T pivotElement = A.get(pivotIdx);
			for(int i=0; i<size; ++i) {
				final T element = A.get(i);
				if(pivotElement.compareTo(element) < 0) {
					A2.add(element); 
				} else if (pivotElement.compareTo(element) > 0) {
					A1.add(element);
				}
			}
			
			A.clear();
			final int a1Size = A1.size();
			if(a1Size == searchK - 1) {
				return pivotElement;
			} else if (a1Size < searchK - 1) {
				for(T elem : A2) {
					A.add(elem);
				}
				searchK -= a1Size + 1;
			} else {
				for(T elem : A1) {
					A.add(elem);
				}				
			}
		}
	}
	
	public static void main(String[] args) {
		SelectionAlgorithm<Integer> s = new SelectionAlgorithm<Integer>();
		final Integer[] arr = new Integer[]{5,3,4,7,6,8,9,10};
//		for(int i=1; i<=arr.length; ++i) 
		System.out.println(s.select(arr, 5));
	}
}
