import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FindDuplicates {
	public static void main(String[] args) {
//		final String[] array = new String[]{"abc", "bca", "abcd", "acb", "cab"};
		
		final FindDuplicates fd = new FindDuplicates();
//		System.out.println(Arrays.toString((fd.findAnagrams(array))));
		for(int i=1; i<7; ++i) {
			System.out.println(i + " " + (fd.findNumDigits(i) + 1) + " " + fd.fact(i));
		}
	}
	
	int fact(int n) {
		return n > 1 ? fact(n-1) * n : 1;
	}
	
	int findNumDigits(int n) {
		double log = 0d;
		for(int i=1; i <= n; ++i) {
			log += Math.log10(i);
		}
//		System.out.println(log);
//		System.out.println(log);
		return (int)log;
	}
		
	/**
	 * Remove anagrams from the String array 
	 * Retain only the first anagram that occurs
	 * @param strings Input string array 
	 */
	public String[] findAnagramsUsingHashFunction(final String[] strings) {
		HashSet<Integer[]> sumAndProd = new HashSet<Integer[]>();
		for(String s: strings) {
			int sum = 0, product = 1;
			for(char c : s.toCharArray()) {
				final int val = c - 'a' + 1;
				sum += val;
				product *= val;
			}
			sumAndProd.add(new Integer[]{sum, product});
			
		}
		return null;
	}
	
	/**
	 * Remove anagrams from the String array 
	 * Retain only the first anagram that occurs
	 * @param strings Input string array
	 */
	public String[] findAnagrams(final String[] strings) {
		final HashSet<String> uniqueStrings = new HashSet<String>();
		
		final ArrayList<String> output = new ArrayList<String>();
		for(String s : strings) {
			final char[] sArr = s.toCharArray();
			Arrays.sort(sArr);
			final String sortedS = new String(sArr);
			if(!uniqueStrings.contains(sortedS.toString())) {
				uniqueStrings.add(sortedS.toString());
				output.add(s);
			} 
		}
		final String[] outputStrArray = new String[output.size()];
		output.toArray(outputStrArray);
		return outputStrArray;
	}
	
	
	
	
}
