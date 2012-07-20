import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FallOut {
	public static void main(String[] args) throws Exception {
		final FallOut f = new FallOut();
		f.run();
	}
	
	boolean[][] visited;
	int M, N;
	char[][] grid;
	int numQueries;
	
	public void run() throws Exception {
		final BufferedReader br = new BufferedReader(new FileReader(new File("/home/sasik/workspace/Programs/src/FallOut.in")));
		final StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		grid = new char[M][N];
		for (int i = 0; i < M; ++i) {
			int j = 0;
			for (char c : br.readLine().toCharArray()) {
				grid[i][j++] = c;
			}
//			System.out.println(Arrays.toString(grid[i]));
		}
		numQueries = Integer.parseInt(br.readLine());
		for(int i=0; i<numQueries; ++i) {
			final StringTokenizer st1 = new StringTokenizer(br.readLine());
			final int x = Integer.parseInt(st1.nextToken());
			final int y = Integer.parseInt(st1.nextToken());
			final int steps = processQuery(x, y);
			if(steps > 0) {
				System.out.println("Fallout " + steps);
			} else {
				System.out.println("Bazinga");
			}
		}
	}


	int processQuery(int x, int y) {
		visited = new boolean[M][N];
		for(int i=0; i<M; ++i) {
			Arrays.fill(visited[i], false);
		}
		return processQuery(x, y, visited, 0);
	}

	int processQuery(int x, int y, final boolean[][] visited, int steps) {
		if (x < 0 || x > (M - 1) || y < 0 || y > (N - 1)) {
			return steps;
		} else {
			if (visited[x][y]) { // Already visited. So in a loop.
				return 0;
			} else {
				visited[x][y] = true;
				switch (grid[x][y]) {
				case 'U':
					return processQuery(x - 1, y, visited, steps + 1);
				case 'R':
					return processQuery(x, y + 1, visited, steps + 1);
				case 'L':
					return processQuery(x, y - 1, visited, steps + 1);
				default:
					return processQuery(x + 1, y, visited, steps + 1);
				}
			}
		}
	}

}
