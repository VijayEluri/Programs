import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TurboSort {
	public static void main(String[] args) {
		TurboSort t = new TurboSort();
		t.run();
	}
	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int noOfNumbers = 0;
		int[] present = new int[1000000];
		Arrays.fill(present, 0);
		try {
			noOfNumbers = Integer.parseInt(reader.readLine().trim());
			Integer arr[] = new Integer[noOfNumbers];
			for(int i=0; i<noOfNumbers; i++) {
				++present[Integer.parseInt(reader.readLine().trim())]; 
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<1000000; ++i) {
				for(int j=0, n=present[i]; j<n; ++j) {
					sb.append(i);
					sb.append('\n');
				}
			}
			System.out.println(sb.toString());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}
}
