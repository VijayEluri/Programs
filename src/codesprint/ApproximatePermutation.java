package codesprint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ApproximatePermutation {
	final int n;
	final int[][] V;
	
	public static void main(String[] args) throws Exception {
		ApproximatePermutation ap = new ApproximatePermutation();
		ap.run();
	}	
	
	public ApproximatePermutation() throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		assert n > 0;
		V =  new int[n][n];
		StringTokenizer st;
		for(int i=0; i<n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; ++j) {
				V[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		for(int i=0; i<n; ++i) {
//			System.out.println(Arrays.toString(V[i]));
//		}
	}
	
	public void run() {
		int iter = 1, prevElement = 1;
		boolean[] used = new boolean[n];
		int[][] permutations = new int[n][n];
		for(int i=0; i<n; ++i) {
			permutations[i][0] = i;
		}
		int bestPerm = 0;
		long maxSum = Long.MIN_VALUE;
		for(int m=0; m<n; ++m) {
			iter = 1; prevElement = m;
			Arrays.fill(used, false);
			used[m] = true;
			long sum = 0l;
			while(iter < n) {
				int max = Integer.MIN_VALUE, index = -1;
				for(int i=0; i<n; ++i) {
					if(!used[i] && max < V[prevElement][i]) {
						max = V[prevElement][i];
						index = i;
					}
				}
				sum += V[prevElement][index];
				used[index] = true;
				permutations[m][iter] = index;
				prevElement = index;
				++iter;
			}
			if(sum > maxSum) {
				maxSum = sum;
				bestPerm = m;
			} 
//			System.out.println(sum);
//			System.out.println(Arrays.toString(permutations[m]));
		}
//		System.out.println("Max sum " + maxSum);
		for(int i=0; i<n-1; ++i) {
			System.out.print(permutations[bestPerm][i] + " ");
		}
		System.out.print(permutations[bestPerm][n-1] + "\n");
	}	
}
