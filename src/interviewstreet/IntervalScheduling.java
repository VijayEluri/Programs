package interviewstreet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Given a list of N intervals, what is the largest subset of intervals you can
 * select such that no three intervals in the subset have a common point?
 * 
 * Input: The first line contains the number of cases T. T cases follow. Each
 * case contains the number N on the first line followed by N lines containing
 * integers a_i and b_i. The ith line denotes the starting and ending points of
 * the ith interval.
 * 
 * Output: Output T lines, one for each test case, containing the desired answer
 * for the corresponding test case.
 * 
 * Constraints: 1 <= T <= 100 2 <= N <= 1000 1 <= a_i <= b_i <= 1000000000
 * (10^9)
 * 
 * @author sasik
 * 
 */

public class IntervalScheduling {
	long[] startTimes;
	long[] endTimes;
	int N;
	int T;
	boolean[][] clash;
	int[] sortedByEndTime;
	int[] numClashes;

	public void run() throws Exception {
		System.out.println("################");
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; ++testCase) {
			N = Integer.parseInt(br.readLine());
			startTimes = new long[N];
			endTimes = new long[N];
			for (int i = 0; i < N; ++i) {
				final StringTokenizer st = new StringTokenizer(br.readLine());
				startTimes[i] = Long.parseLong(st.nextToken());
				endTimes[i] = Long.parseLong(st.nextToken());
			}
			this.setupClashes();
//			this.sortByEndTimes();
//			final int answer = getMaxSchedulableIntervals();
		}
		
		// Do DFS and find break when you see an edge from child of this node to parent of this node
		boolean[] visited = new boolean[N];
		int[] parents = new int[N];
		Arrays.fill(visited, false);
		Stack<Integer> s = new Stack<Integer>();
		s.add(0);
		parents[0] = -1;
		while(!s.isEmpty()) {
			final int node = s.pop();
			visited[node] = true;
			
			for(int i=0; i<N; ++i) {
				if(!visited[i] && clash[i][node]) {
					parents[i] = node;
					s.push(i);
				}
			}			
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; ++i) {
			if(visited[i]) {
				sb.delete(0, sb.length());
				int start = parents[i];
				while(start != -1) {
					start = parents[start];
					sb.append(start + " <- ");
				}
			}
		}
	}
	

//	private void sortByEndTimes() {
//		sortedByEndTime = new int[N];
//		for(int i=0; i<N; ++i) {
//			sortedByEndTime[i] = i;
//		}
//		
//		for(int i=0; i<N; ++i) {
//			for(int j=0; j<N; ++j) {
//				if(endTimes[sortedByEndTime[i]] < endTimes[sortedByEndTime[j]]) {
//					int swap = sortedByEndTime[i];
//					sortedByEndTime[i] = sortedByEndTime[j];
//					sortedByEndTime[j] = swap; 
//				}
//			}
//		}
//		
//		for(int i=0; i<N; ++i) {
//			System.out.println(sortedByEndTime[i] + "\t" + endTimes[sortedByEndTime[i]]);
//		}
//	}
//
	private void setupClashes() {
		numClashes = new int[N];
		clash = new boolean[N][N];
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				clash[i][j] = clash[j][i] = false;
				if((startTimes[i] <= startTimes[j]) && (endTimes[i] >= startTimes[j]) ) {
					clash[i][j] = clash[j][i] = true;
					++numClashes[i];
					++numClashes[j];
				}
			}
		}
	}
//	
//	/**
//	 * O(n^2) amortized
//	 * 
//	 * @return
//	 */
//	private int getMaxSchedulableIntervals() {
//		/* Sort based on entTimes */
//		int maxPossible = Integer.MIN_VALUE;
//		for(int fixedInterval = 0; fixedInterval < N-1; ++fixedInterval) {
//			for(int floatingInterval = fixedInterval + 1; floatingInterval < N; ++floatingInterval) {				
//				int numPossible = 2;
//				for(int i=0; i<N; ++i) {
//					
//				}
//			}
//		}
//		return 0;
//	}
 
	public static void main(String[] args) throws Exception {
		IntervalScheduling s = new IntervalScheduling();
		s.run();
	}
}
