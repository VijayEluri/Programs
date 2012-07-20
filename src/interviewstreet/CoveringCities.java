package interviewstreet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoveringCities {
	int positions[];
	double K;
	int N;
	public CoveringCities() throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		positions = new int[N];
		for(int i=0; i<N; ++i) {
			positions[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(positions);
	}
	
	public int run() {
		double pos = positions[0] + K;
		int numAntennas = 1;
		int idx = 1;
		while(idx < N) {
			if((pos + K) < positions[idx]) {
				pos = positions[idx] + K;
				++numAntennas;
			}
			++idx;
		}
		return numAntennas;
	}
	
	public static void main(String[] args) throws Exception {
		CoveringCities c = new CoveringCities();
		System.out.println(c.run());
	}
}
