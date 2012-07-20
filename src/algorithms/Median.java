package algorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * Will find the median of a given array in O(n) time
 * @author sasik
 * 
 */
public class Median {	
	/**
	 * For testing - Randomized version. Uses Selection Algorithm 
	 * @param array
	 * @return
	 */
	public static int findMedianRandomized(int[] array) {
		SelectionAlgorithm<Integer> s = new SelectionAlgorithm<Integer>();
		Integer[] a = new Integer[array.length];
		for(int i=0; i<array.length; ++i) {
			a[i] = array[i];			
		}
		return s.select(a, array.length / 2);
	}
	
	public static int findMedian(int[] array) {
		return findMedian(array, 0, array.length - 1);
	}
	
	public static int findMedian(int[] array, int startIdx, int endIdx) {
		if(endIdx - startIdx <= 5) {
			Arrays.sort(array, startIdx, endIdx + 1);
			return array[startIdx + (endIdx - startIdx) / 2];
		} else {
			// Divide into n/5 groups
			int medianStartIdx = startIdx; 
			final int numGroups = (endIdx - startIdx) / 5 + 1;
			int sIdx = startIdx, eIdx = sIdx + 4;
			System.out.println(Arrays.toString(array));
			for(int i=0; i<numGroups-1; ++i) {	
				Arrays.sort(array, sIdx, eIdx+1);
				System.out.println("Before: " + Arrays.toString(array));
				// Replace the element with the median from here
				array[medianStartIdx] = array[(sIdx + eIdx) / 2];
				++medianStartIdx;
				sIdx += 5;
				eIdx = sIdx + 4;
				System.out.println("After: " + Arrays.toString(array));
			}
			
			// Handle last group
			Arrays.sort(array, sIdx, endIdx+1);
			array[medianStartIdx] = array[(sIdx + eIdx) / 2];
			System.out.println(Arrays.toString(array));
			return findMedian(array, startIdx, medianStartIdx);
		} 
	}
	
	/**
	 * Given an array and a pivot, this function 
	 * partitions the array based on the pivot
	 * and returns the appropriate position 
	 * of the pivot. 
	 * @param array Input array
	 * @param pivot Element around which we need to partition
	 * @return Appropriate position of the pivot 
	 * after paritioning the array
	 */
	public static int partition(int[] array, int pivotIdx, int leftIdx, int rightIdx) {
		int pivot = array[pivotIdx];
		int temp = array[rightIdx];
		array[rightIdx] = pivot;
		array[pivotIdx] = temp;
		
		int storeIdx = leftIdx;
		for(int i=leftIdx; i<rightIdx; ++i) {
			if(array[i] <= pivot) {
				temp = array[storeIdx];
				array[storeIdx] = array[i];
				array[i] = temp;
				++storeIdx;
			}			
		}
		array[rightIdx] = array[storeIdx];
		array[storeIdx] = pivot;
		return storeIdx;
	}
	
	
	public static void main(String[] args) {
		final int numElements = 10;
		int[] a = new int[numElements];
		Random r = new Random();
		for(int i=0; i < numElements; ++i) {
			a[i] = r.nextInt(100);
		}
		int[] b = a.clone();
		Arrays.sort(a);
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(a));
		for(int i=0; i<a.length; ++i) {
			int[] c = b.clone();
			final int pos = Median.partition(c, i, 0, a.length -1);					
			if(pos != i) {
				System.out.println("ERROR: " + i + " " + pos);
			}
			System.out.println(Arrays.toString(c));
		}
//		System.out.println("Median: " + Median.findMedian(a));
//		Arrays.sort(a);
//		System.out.println(Arrays.toString(a));
//		System.out.println("Actual: " + a[a.length / 2] + "\t" + a[a.length / 2 + 1]);
	}
}
