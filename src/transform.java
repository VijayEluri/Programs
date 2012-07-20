/*
ID: kasturisa1
LANG: JAVA
TASK: transform
 */
import java.io.*;
import java.util.*;

/**
 * @author sasik
 * 
 */
public class transform {	
	public char initial[][];	
	public char after[][];

	public int N;

	public static void main(String[] args) throws IOException {
		transform t = new transform();
		t.readInput();

		PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		if (compare(t.ninetyClock(), t.after, t.N)) {
			w.append("1\n");
			w.close();
			return;
		}
		if(compare(t.oneEighty(), t.after, t.N)) {
			w.append("2\n");
			w.close();
			return;
		}		
		if(compare(t.twoSeventy(), t.after, t.N)) {
			w.append("3\n");
			w.close();
			return;
		}
		if(compare(t.rotHori(),t.after,t.N)) {
			w.append("4\n");
			w.close();
			return;
		}
		if(compare(t.ninetyClock(t.rotHori()), t.after, t.N) || 
				compare(t.oneEighty(t.rotHori()), t.after, t.N) ||
				compare(t.twoSeventy(t.rotHori()), t.after, t.N) ){
			w.append("5\n");
			w.close();
			return;
		}
		if(compare(t.initial, t.after, t.N)) {
			w.append("6\n");
			w.close();
			return;
		}
		w.append("7\n");
		w.close();
		return;
	}

	public void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/transform.in"));
		N = Integer.parseInt(br.readLine());
		initial = new char[N][N];
		after = new char[N][N];

		for (int i = 0; i < N; i++) {
			final char tmp[] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++)
				initial[i][j] = tmp[j];
		}

		for (int i = 0; i < N; i++) {
			final char tmp[] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++)
				after[i][j] = tmp[j];
		}

		/* Verify */
		// System.out.println("Initial");
		// for(char[] x : initial) System.out.println(Arrays.toString(x));
		//		
		// System.out.println("After");
		// for(char[] x : after) System.out.println(Arrays.toString(x));
	}

	public char[][] ninetyClock(char[][] init) {
		char[][] ret = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ret[i][j] = init[N - 1 - j][i];
			}
		}

		/* Verify */
		// System.out.println("Before ninety clock");
		// for(char[] x : init) System.out.println(Arrays.toString(x));
		// System.out.println("Ninety Clock");
		// for(char[] x : ret) System.out.println(Arrays.toString(x));
		return ret;
	}

	public char[][] ninetyClock() {
		char[][] ret = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ret[i][j] = initial[N - 1 - j][i];
			}
		}

		/* Verify */
		// System.out.println("Before ninety clock");
		// for(char[] x : initial) System.out.println(Arrays.toString(x));
		// System.out.println("Ninety Clock");
		// for(char[] x : ret) System.out.println(Arrays.toString(x));
		//		
		return ret;
	}

	public char[][] rotHori() {
		char[][] ret = new char[N][N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				ret[i][j] = initial[i][N - 1 - j];
			}
		}

		/* Verify */
		// System.out.println("Before rotate horizontal");
		// for(char[] x : initial) System.out.println(Arrays.toString(x));
		// System.out.println("After rotate horizontal");
		// for(char[] x : ret) System.out.println(Arrays.toString(x));
		return ret;
	}

	public char[][] rotHori(char[][] init) {
		char[][] ret = new char[N][N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				ret[i][j] = init[i][N - 1 - j];
			}
		}

		/* Verify */
		// System.out.println("Before rotate horizontal");
		// for(char[] x : init) System.out.println(Arrays.toString(x));
		// System.out.println("After rotate horizontal");
		// for(char[] x : ret) System.out.println(Arrays.toString(x));
		return ret;
	}

	public char[][] oneEighty(char[][] init) {
		char[][] ret = ninetyClock(ninetyClock(init));
		return ret;
	}

	public char[][] oneEighty() {
		char[][] ret = ninetyClock(ninetyClock());

		/* Verify */
		// System.out.println("Before one eighty");
		// for(char[] x : initial) System.out.println(Arrays.toString(x));
		// System.out.println("After one eighty");
		// for(char[] x : ret) System.out.println(Arrays.toString(x));
		return ret;
	}

	public char[][] twoSeventy() {
		char[][] ret = ninetyClock(ninetyClock(ninetyClock()));

		/* Verify */
		// System.out.println("Before two seventy");
		// for(char[] x : initial) System.out.println(Arrays.toString(x));
		// System.out.println("After two seventy");
		// for(char[] x : ret) System.out.println(Arrays.toString(x));
		return ret;
	}

	public char[][] twoSeventy(char[][] init) {
		char[][] ret = ninetyClock(ninetyClock(ninetyClock(init)));
		return ret;
	}

	public static boolean compare(char[][] a, char[][] b, int N) {
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (a[i][j] != b[i][j]) {
					flag = false;
					break;
				}
			}
			if (!flag)
				break;
		}
		return flag;
	}

}
