import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class TSORT {

	public static void main(String[] args) {
		int noOfTestCases = 0;
		long val = 10000001;

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int temp = 0;
		int nos[] = new int[1000001];
		try {
			noOfTestCases = Integer.parseInt(reader.readLine());
			for (int i = 0; i < noOfTestCases; i++) {
				temp = Integer.parseInt(reader.readLine());
				nos[temp]++;
			}

			for (long i = 0; i < val; i++) {
				long t = 0;
				// long t = nos[i];
				for (long j = 0; j < t; j++) {
					System.out.println(i);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
