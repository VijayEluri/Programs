package algorithms;

import java.util.HashMap;

public class FIndMaxContinuousShuffledSubSequence {
	public static int[] input = {300, 1, 200, 3, 500, 2};	
		
	public static void main(String[] args) {
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		int maxLength = Integer.MIN_VALUE;
		for(int i: input) {
			if(map.containsKey(i)) {
				
			}
		}
	}
	
	private class Node {
		int sId; 
		int length;
	}
}


