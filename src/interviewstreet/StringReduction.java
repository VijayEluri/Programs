package interviewstreet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * String Reduction (25 Points)
 * 
 * Given a string consisting of a,b and c's, we can perform the following
 * operation: Take any two adjacent distinct characters and replace it with the
 * third character. For example, if 'a' and 'c' are adjacent, they can replaced
 * with 'b'. What is the smallest string which can result by applying this
 * operation repeatedly?
 * 
 * Input: The first line contains the number of test cases T. T test cases
 * follow. Each case contains the string you start with.
 * 
 * Output: Output T lines, one for each test case containing the smallest length
 * of the resultant string after applying the operations optimally.
 * 
 * Constraints: 1 <= T <= 100 The string will have at most 100 characters.
 * 
 * Sample Input: 3 cab bcab ccccc
 * 
 * Sample Output: 2 1 5
 * 
 * @author sasik
 * 
 */
public class StringReduction {
	public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        for (int i = 0; i < T; i++) {
            final String s = br.readLine().trim();
            System.out.println(s + "\t" + performDP(s.toCharArray()));
        }
    }
	
	public static int performDP(final char[] characters) {
		return recursiveDp(characters, characters.length - 2,characters[characters.length - 1]);
	}
		
	
	public static int recursiveDp(final char[] characters, int pos, char nextChar) {
		if(pos == 0) {
			if(characters[0] != nextChar) {
				System.out.println("Pos:" + pos + " Char:" + characters[pos] + " Next:" + nextChar + " Res:0");
				return 0; 
			} else {
				System.out.println("Pos:" + pos + " Char:" + characters[pos] + " Next:" + nextChar + " Res:2");
				return 1;
			}
		} else {
			final int nonRed = recursiveDp(characters, pos - 1, characters[pos]) + 1;
			int red = Integer.MAX_VALUE;
			if(characters[pos] != nextChar) {
				final char pres = characters[pos];
				if((pres == 'a' && nextChar == 'b') || (pres == 'b' && nextChar == 'a')) {
					red = recursiveDp(characters, pos - 1, 'c');
				} else if((pres == 'c' && nextChar == 'b') || (pres == 'b' && nextChar == 'c')) {
					red = recursiveDp(characters, pos - 1, 'a');
				} else if ((pres == 'a' && nextChar == 'c') || (pres == 'c' && nextChar == 'a')) {
					red = recursiveDp(characters, pos - 1, 'b');
				}
			}
			final int res = Math.min(nonRed, red);
			System.out.println("Pos:" + pos + " Char:" + characters[pos] + " Next:" + nextChar + " Res:" + res);			 
			return res;			
		}
	}
}
