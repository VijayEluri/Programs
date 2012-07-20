package codesprint;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class AllSubStrings {
	final String[] strs;
	final HashSet<String> substrs;
	final int[] queries;
	final int T;
	
	public static void main(String[] args) throws Exception {
		AllSubStrings a = new AllSubStrings();
		a.run();
	}
	
	public AllSubStrings() throws Exception {
		substrs = new HashSet<String>();
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		strs = new String[T];
		for(int i=0; i<T; ++i) {
			strs[i] = scanner.next();
		}
//		System.out.println(Arrays.toString(strs));
		queries = new int[scanner.nextInt()];
		for(int i=0, n=queries.length; i<n; ++i) {
			queries[i] = scanner.nextInt();
		}
//		System.out.println(Arrays.toString(queries));
	}	 
	
	public void run() {
		for(int i=0; i<T; ++i) {
			allSubStrings(strs[i]);
		}
		
		final String[] substrArr = new String[substrs.size()];
		substrs.toArray(substrArr);
		Arrays.sort(substrArr);
		final int numSubstrs = substrs.size();
		for(int i=0, n=queries.length; i<n; ++i) {
			if(queries[i] > numSubstrs) {
				System.out.println("INVALID");
			} else { 
				System.out.println(substrArr[queries[i] - 1]);
			}
		}
	}
	
	private void allSubStrings(final String s) {
		final int len = s.length();
		for(int i=0; i<len; ++i) {
			for(int j=i+1; j<=len; ++j) {
				substrs.add(s.substring(i, j));
			}
		}
	}
	
	private void seiver(final String s) {
		
	}
}
