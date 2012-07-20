/*
ID: kasturisa1
LANG: JAVA
TASK: calfflac
 */

import java.io.*;
import java.util.*;
import java.text.*;

public class calfflac {
	private char input[];
	private Character transformed[];
	private int size;
	private int gPalSize;
	private int gStart, gEnd;
	
	private Integer reverseMapping[];
	
	public static void main(String[] args) throws IOException {
		calfflac c = new calfflac();
		c.readInput();
		c.transform();
		c.process();
	}
	
	public calfflac() {
				
	}
	
	private void transform() {
		ArrayList<Character> toBeChecked = new ArrayList<Character>();
		ArrayList<Integer> reverseMapping = new ArrayList<Integer>();
		for(int i=0; i<input.length; i++) 
			if(Character.isLetter(input[i])) {
				reverseMapping.add(i);
				toBeChecked.add(Character.toLowerCase(input[i]));
			}
		this.reverseMapping = new Integer[reverseMapping.size()]; 
		reverseMapping.toArray(this.reverseMapping);
		this.transformed = new Character[toBeChecked.size()];
		toBeChecked.toArray(this.transformed);
	}

	private boolean isPalindrome(final int start, final int end) {
		final int l = end - start;
		if(l == 0 || l == 1) 
			return true;
		else {
			for(int i=0; i < l/2; i++) {
//				System.out.print(transformed[start+i] + "" + transformed[start+l-i-1] + ",");
				if(transformed[start+i] != transformed[start+l-i-1]) {
//					System.out.println();
					return false;
				}
			}
			return true;
		}
	}

	public void readInput() throws IOException {
		final BufferedReader br = new BufferedReader(new FileReader(
				"calfflac.in"));
		final StringBuilder sb = new StringBuilder();
		while (true) {
			final String s = br.readLine();
			if(s != null) {
				sb.append(s);
				sb.append('\n');
			}
			else break;
		}		
		br.close();
		sb.deleteCharAt(sb.length()-1);
		input = sb.toString().toCharArray();
	}

	public void process() throws IOException {
		gStart = 0; gEnd = 1; gPalSize = 1; 
		int preSize = 1;
//		System.out.println("Bigger: Start: " + gStart + ", End: " + gEnd + ", Size: " + gPalSize);
		for(int start=0, n=transformed.length; start < n; start++) {
			for(int end=start+preSize; end < n+1; end++) {		
				if(reverseMapping[end-1] - reverseMapping[start] > 2000) break;
//				System.out.println("Start: " + start + ", End: " + end + ", Presize: " + preSize);
				if(isPalindrome(start, end)) {
					if(preSize < (end-start)) {
						preSize = end-start; gStart = start; gEnd = end; gPalSize = preSize;
//						System.out.println("Bigger: Start: " + gStart + ", End: " + gEnd + ", Size: " + gPalSize);
					}
				}
			}
		}
		
//		System.out.println("Start: " + gStart + ", End: " + gEnd + ", Size: " + gPalSize);
//		for(int i=reverseMapping[gStart]; i<=reverseMapping[gEnd-1]; i++) System.out.print(input[i]);
		PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter("calfflac.out")));
		w.append(gPalSize + "\n");
		for(int i=reverseMapping[gStart]; i<=reverseMapping[gEnd-1]; i++) w.append(input[i]);
		w.append("\n");
		w.close();
	}

}
