import java.util.Arrays;
import java.util.Scanner;

public class BooleanMatrixMultiplication {
	public static void main(String[] args) {
		BooleanMatrixMultiplication b = new BooleanMatrixMultiplication();
		b.read();
		b.process();
	}

	int numTestCases = 0;

	public void read() {
		Scanner scanner = new Scanner(System.in);
		numTestCases = scanner.nextInt();
	}

	public void process() {
		Scanner sc = new Scanner(System.in);
		boolean[][] A, B, C;
		int n = 0;
		while (n++ < numTestCases) {
			final int N = sc.nextInt();
			A = new boolean[N][N];
			B = new boolean[N][N];
			C = new boolean[N][N];
			for (int j = 0; j < N; ++j) {
				for (int k = 0; k < N; ++k) {
					A[j][k] = sc.nextInt() == 0 ? false : true;
				}
			}

			for (int j = 0; j < N; ++j) {
				for (int k = 0; k < N; ++k) {
					B[j][k] = sc.nextInt() == 0 ? false : true;
				}
			}

			for (int j = 0; j < N; ++j) {
				for (int k = 0; k < N; ++k) {
					C[j][k] = sc.nextInt() == 0 ? false : true;
				}
			}
			
			System.out.println("A");
			for (int j = 0; j < N; ++j) {
				System.out.println(Arrays.toString(A[j]));
			}
			
			System.out.println("B");
			for (int j = 0; j < N; ++j) {
				System.out.println(Arrays.toString(B[j]));
			}
			
			System.out.println("C");
			for (int j = 0; j < N; ++j) {
				System.out.println(Arrays.toString(C[j]));
			}

			System.out.println(processMatrix(N, A, B, C));
		}
	}

	boolean processMatrix(int N, boolean[][] A, boolean[][] B, boolean[][] C) {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				final boolean res = C[i][j];
				boolean pres = false;
				for (int k = 0; k < N; ++k) {
					final boolean t = A[i][k] & B[k][j];
					pres |= t;
					if (!res && (A[i][k] & B[k][j])) {
						return false;
					}
				}
				if (pres ^ res) {
					return false;
				}
			}
		}
		return true;
	}
}
