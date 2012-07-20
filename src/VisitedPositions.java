import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class VisitedPositions {

	public static void main(String[] args) {
		System.out.println(VisitedPositions.visitedPositions(new String[] {"..*...*."
				,"**.....*"
				,"*..*...."
				,"*..*...."
				,".....*.."
				,"....*..K"
				,"**.*...*"
				,"..**...."}));
	}

	static int visitedPositions(String[] board) {
		final boolean[][] isAccessible = new boolean[8][8];
		assert board.length == 8;
		boolean foundNight = false;
		int kR = -1, kC = -1;
		for (int i = 0; i < 8; ++i) {
			Arrays.fill(isAccessible[i], true);
			final char[] row = board[i].toCharArray();
			for (int j = 0; j < 8; ++j) {
				switch (row[j]) {
				case '*':
					isAccessible[i][j] = false;
					break;
				case 'K':
					assert !foundNight;
					foundNight = true;
					kR = i;
					kC = j;
				}
			}
		}

		int[][] numAccPos = new int[8][8];
		for (int i = 0; i < 8; ++i) {
			Arrays.fill(numAccPos[i], 0);
		}
//		System.out.println("Knight pos: " + kR + " " + kC);

		// Its quite small. Brute force
		final HashMap<Integer, HashMap<Integer, ArrayList<Integer[]>>> rowToColToAccesiblePos = new HashMap<Integer, HashMap<Integer, ArrayList<Integer[]>>>();
		for (int row = 0; row < 8; ++row) {
			final HashMap<Integer, ArrayList<Integer[]>> present = new HashMap<Integer, ArrayList<Integer[]>>();
			rowToColToAccesiblePos.put(row, present);
			for (int col = 0; col < 8; ++col) {
				present.put(col, accessiblePositions(isAccessible, row, col));
			}
		}		

		int preRow = kR, preCol = kC;
		boolean nextStepExists = true;
		int totalMoves = 0;
		while(nextStepExists) {
			++totalMoves;
			int nextBestRow = Integer.MAX_VALUE, nextBestCol = Integer.MAX_VALUE, minAccVal = Integer.MAX_VALUE;
			nextStepExists = false;
			for (Integer[] accPos : rowToColToAccesiblePos.get(preRow).get(preCol)) {				
				isAccessible[preRow][preCol] = false;
				final int row = accPos[0], col = accPos[1];

				if (isAccessible[row][col]) {				
					nextStepExists = true;
					int preNumAcc = 0;
					for (Integer[] presentAcc : rowToColToAccesiblePos.get(row).get(col)) {
						if (isAccessible[(int) presentAcc[0]][(int) presentAcc[1]]) {
							++preNumAcc;
						}
					}
//					System.out.println("Row " + row + " Col " + col + " numAcc " + preNumAcc);
					if (preNumAcc < minAccVal) {
						nextBestRow = row;
						nextBestCol = col;
						minAccVal = preNumAcc;
					} else if (preNumAcc == minAccVal) {
						if (row < nextBestRow) {
							nextBestRow = row;
							nextBestCol = col;
						}
						else if (row == nextBestRow) {
							if (col < nextBestCol) {
								nextBestCol = col;
							}
						}
					}
				}
			}
			if (nextBestRow != Integer.MAX_VALUE && nextBestCol != Integer.MAX_VALUE) {
//				System.out.println("NextBestRow " + nextBestRow + " NextBestCol " + nextBestCol + " Accmoves " + minAccVal);
				preRow = nextBestRow;
				preCol = nextBestCol;
			} else {
				break;
			}
		}	
		
		return totalMoves;
	}

	static int getNumAccPos(final int kR, final int kC, boolean[][] acc) {
		int[][] poss = new int[][] { new int[] { 1, 2 }, new int[] { 2, 1 },
				new int[] { -1, 2 }, new int[] { -2, 1 }, new int[] { -1, -2 },
				new int[] { -2, -1 }, new int[] { -1, -2 }, new int[] { -1, 2 }, };
		int numAcc = 0;
		int r = 0, c = 0;
		for (int[] pos : poss) {
			r = kR + pos[0];
			c = kC + pos[1];
			if ((r >= 0) && (r < 8) && (c >= 0) && (c < 8)) {
				if (acc[r][c]) {
					++numAcc;
				}
			}
		}
//		System.out.println("Row " + kR + " Col " + kC + " numAcc " + numAcc);
		return numAcc;
	}

	static ArrayList<Integer[]> accessiblePositions(final boolean[][] acc, final int kR, final int kC) {
		int[][] poss = new int[][] { new int[] { 1, 2 }, new int[] { 2, 1 },
				new int[] {2, -1}, new int[] { 1, -2 }, new int[] {-1, -2},
				new int[] { -2, -1 }, new int[] { -2, 1}, new int[] { -1, 2 }, };
		final ArrayList<Integer[]> accPos = new ArrayList<Integer[]>();
		int r = 0, c = 0;
		for (int[] pos : poss) {
			r = kR + pos[0];
			c = kC + pos[1];
			if ((r >= 0) && (r < 8) && (c >= 0) && (c < 8)) {
				if(acc[r][c]) {
					accPos.add(new Integer[] { r, c });
				}
			}
		}

		return accPos;
	}
}
