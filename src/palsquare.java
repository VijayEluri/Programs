
import java.io.*;
import java.util.*;

/*
: kasturisa1
LANG: JAVA
TASK: palsquare
 */
public class palsquare {
	private int base;
	public boolean isPalindrome(String s) {
		final int l  = s.length();
		if(l==1) return true;
		final char[] sArr = s.toCharArray();
		for(int i=0;i < (l/2); ++i) {
			if( sArr[i] != sArr[l-i-1]) 
				return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException{
		palsquare ps = new palsquare();
		ps.process();
	}
	
	public void process() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("palsquare.in"));
		base = Integer.parseInt(br.readLine());
		PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		for(int i=1; i<300; i++) {
			final String s = Integer.toString(i*i, base).toUpperCase();			
			if(isPalindrome(s)) {
//				System.out.println("N = " + i + " Square " + Integer.toString(i*i, base));
				w.append(Integer.toString(i, base).toUpperCase() + " " + s + "\n");
			}
		}
		w.close();
	}

}
