package codesprint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PickingCards {
	public static void main(String[] args) throws Exception {
		final PickingCards pc = new PickingCards();
		pc.run();
	}

	final int T;
	final int[] N;
	final int[][] data;

	public PickingCards() throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		N = new int[T];
		data = new int[T][];
		StringTokenizer st;
		for (int i = 0; i < T; ++i) {
			final int len = Integer.parseInt(br.readLine());
			data[i] = new int[len];
			N[i] = len;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < len; ++j) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
			// System.out.println("Testcase: " + i + " Data: " +
			// Arrays.toString(data[i]));
		}
	}

	public void run() {
		for(int i=0; i<T; ++i) {
			System.out.println(runTestCase(i));
		}
	}

	private long runTestCase(final int index) {
		final int[] d = data[index];
		final int len = N[index];
		final boolean[] picked = new boolean[len];
		Arrays.fill(picked, false);
		int numPicked = 0;
		long result = 1l;
		do {
			final int step = findNext(d, picked);
			if(step == -1) {
				break;
			} else {
				result = (result * step) % 1000000007l;
			}
			++numPicked;
		} while(numPicked != len);
		
		// Check if all cards are picked
		for(boolean p: picked) {
			if(!p) return 0;
		}
		
		return result;
	}

	private int findNext(final int[] data, final boolean[] picked) {
		int num = 0;
		boolean possible = false;
		boolean setFlag = true;
		for (int i = 0, n = data.length; i < n; ++i) {
			if (!picked[i] && data[i] < 1) {
				possible = true;
				++num;
				if (setFlag) {
					picked[i] = true;
					setFlag = false;
				}
			}
		}
		if (possible) {
			for (int i = 0, n = data.length; i < n; ++i) {
				data[i]--;
			}
		}
		if (possible) {
			return num;
		} else {
			return -1;
		}
	}
}
