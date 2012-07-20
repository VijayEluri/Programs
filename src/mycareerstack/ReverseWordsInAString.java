package mycareerstack;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Given a linked list containing characters that form a string such as
--------- "my career stack" ---------
Reverse the characters of each word, keeping the order of the words same such that the output will be
--------- "ym reerac kcats" ---------
 * @author sasidhark
 */

public class ReverseWordsInAString {

	LinkedList<Character> inputString; 
	
	public static void main(String[] args) {
		ReverseWordsInAString r = new ReverseWordsInAString("my career stack");
		System.out.println(r.run());
	}

	public ReverseWordsInAString(String input) {
		inputString = new LinkedList<Character>();
		for(char c: input.toCharArray()) {
			inputString.add(c);
		}
	}
	
	/**
	 * Version 1: Uses extra memory but completes in one scan of the string
	 * @return
	 */
	public String run() {
		Iterator<Character> itr = inputString.iterator();
		LinkedList<Character> master = new LinkedList<Character>(), subordinate = new LinkedList<Character>();
		
		for(;itr.hasNext();) {
			final char c = itr.next();
			if(c == ' ') {
				if(subordinate.size() > 0) {
					if(master.size() > 0) {
						master.add(' ');
					}
					for(char value : subordinate) {
						master.add(value);
					}
				}
				subordinate.clear();
			} else {
				subordinate.addFirst(c);
			}
		}
		if(subordinate.size() > 0) {
			if(master.size() > 0) {
				master.add(' ');
			}
			for(char value : subordinate) {
				master.add(value);
			}
		}
		return master.toString();
	}
	
	/** 
	 * Version 2: 
	 * 
	 */	
}
