package interviewstreet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class UnfriendlyNumbers {
	public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final int K = Integer.parseInt(br.readLine());
        ArrayList<Integer> unfriendly = new ArrayList<Integer>();
        for(int i=0; i<N; ++i) {
        	unfriendly.add(Integer.parseInt(br.readLine()));
        }
    }	
	
	public static int gcd(int a, int b) {
		while(b != 0) {
			int temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}
}
