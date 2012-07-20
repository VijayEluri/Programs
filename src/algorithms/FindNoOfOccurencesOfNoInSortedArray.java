package algorithms;

/**
 * Find the number of occurrences of an element in a sorted array in O(logn)
 * time.
 * 
 * @author sasik
 */

public class FindNoOfOccurencesOfNoInSortedArray<T extends Comparable<T>> {
	public int findFirst(final T[] array, final T element) {
		assert array != null;
		int startIdx = 0, endIdx = array.length;
		while(startIdx <= endIdx) {
			int midIdx = (startIdx + endIdx) / 2;
			if( midIdx == 0 || (array[midIdx].compareTo(element) == 0 && array[midIdx - 1].compareTo(element) < 0)) {
				return midIdx;
			}
			if(array[midIdx].compareTo(element) < 0) {
				startIdx = midIdx + 1;
			} else {
				endIdx = midIdx - 1;
			}
		}
		return startIdx;
	}
	
	public int findLast(final T[] array, final T element) {
		assert array != null;
		int startIdx = 0, endIdx = array.length;
		while(endIdx >= startIdx) {
			int midIdx = (startIdx + endIdx) / 2;
			if(midIdx == array.length - 1 || (array[midIdx].compareTo(element) == 0 && array[midIdx + 1].compareTo(element) > 0)){
				return midIdx;
			}
			if(array[midIdx].compareTo(element) > 0) {
				endIdx = midIdx - 1;				
			} else {
				startIdx = midIdx + 1;
			}
		}
		return endIdx;
	}
	
	public static void main(String[] args) {
		FindNoOfOccurencesOfNoInSortedArray<Integer> f = new FindNoOfOccurencesOfNoInSortedArray<Integer>();
		Integer[] array = new Integer[]{1,1,2,2,3,3,3,4,4,4,5,5,5,6,7,8,9,9};
		for(int i=1; i<=9; ++i) {
			System.out.println("Element: " + i + " first:" + f.findFirst(array, i) + " last:" + f.findLast(array, i));
		}
	}
}
