package interviewstreet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DuplicateDetection {
	private class Record implements Comparable<Record> {
		String phoneNumber; 
		String emailAddress;		
		
		@Override
		public int compareTo(Record another) {			
			if(another.phoneNumber.compareTo(phoneNumber) == 0 || another.emailAddress.compareTo(emailAddress) == 0) {
				return 0;
			} else {
				 if(another.phoneNumber.compareTo(phoneNumber) == 0) {
					 return another.emailAddress.compareTo(emailAddress);
				 } else {
					 return another.phoneNumber.compareTo(phoneNumber);
				 }
			}
		}
		
		public Record(String input) {
			String[] splits = input.split(",");
			phoneNumber = splits[4];
			emailAddress = splits[5];
		}
	}
	
	
	public void run() throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N == 1) {
			System.out.println("1");
			return;
		}
		
		Record[] rs = new Record[N];
		for(int i=0; i<N; ++i) {
			rs[i] = new Record(br.readLine().trim());
		}
		Arrays.sort(rs);
		
		boolean[] invalid = new boolean[N];
		Arrays.fill(invalid, false);
		for(int i=0; i<N-1; ++i) {
			for(int j=i+1; j<N; ++j) {
				if(rs[i].compareTo(rs[j]) == 0) {
					invalid[j] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		DuplicateDetection d = new DuplicateDetection();
		d.run();
	}
}
