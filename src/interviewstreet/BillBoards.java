package interviewstreet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BillBoards {
	int N, K;
	int[] profits;
	int dpTable[][];
	
	public void run() throws Exception {
		System.out.println("################");
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		profits = new int[N];
		for(int i=0; i<N; ++i) {
			profits[i] = Integer.parseInt(br.readLine());
		}
		
		dpTable = new int[N][K];
		performDP();
	}
	
	public void performDP() {
		int total = 0;
		for(int i=0; i<K; ++i) {
			Arrays.fill(dpTable[i], -1);
			total += profits[i];
			for(int j=0; j<K; ++j) {
				
			}
		}
	}
}
