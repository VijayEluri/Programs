/*
 ID: kasturisa1
 LANG: JAVA
 TASK: clocks
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentLinkedQueue;

public class clocks {
	public static void main(String[] args) throws Exception {
		final clocks c = new clocks();
		c.readInput();
		c.run();
	}

	final int[] powersOfFour = new int[] { 1, 4, 16, 64, 256, 1024, 4096, 16384, 65536, };

	int initialState;

	public clocks() {

	}
	
	public String run() {
		Queue<Integer[]> moves = new ConcurrentLinkedQueue<Integer[]> ();
		moves.add(new Integer[]{1});
		ArrayList<Integer> tillNowSteps = new ArrayList<Integer>();
		int presentState = initialState;
		while(!moves.isEmpty()) { 
			
		}
		return "";
	}

	public void readInput() throws Exception {
		final BufferedReader br = new BufferedReader(new FileReader("clocks.in"));
		StringBuffer sb = new StringBuffer();
		sb.append(br.readLine());
		sb.append(br.readLine());
		sb.append(br.readLine());
		StringTokenizer st = new StringTokenizer(sb.toString());
		int index = 0;
		initialState = 0;
		while (st.hasMoreTokens()) {
			final int state;
			switch (Integer.parseInt(st.nextToken())) {
			case 3:
				state = 0;
				break;
			case 6:
				state = 1;
				break;
			case 9:
				state = 2;
				break;
			default:
				state = 3;
				break;
			}
			initialState += powersOfFour[index++] * state;
		}		
	}

	private int rotate(int presentState, final int move, StringBuilder sb) {
		final char[] stateArray = Integer.toString(presentState, 4).toCharArray();
		int presentXState = 0, targetXState = 0;
		switch (move) {		
		case 1:
			presentXState = Integer.parseInt("" + stateArray[8]); // A
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[0];

			presentXState = Integer.parseInt("" + stateArray[7]); // B
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[1];

			presentXState = Integer.parseInt("" + stateArray[5]); // D
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[3];

			presentXState = Integer.parseInt("" + stateArray[4]); // E
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[4];
			break;

		case 2:
			presentXState = Integer.parseInt("" + stateArray[8]); // A
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[0];

			presentXState = Integer.parseInt("" + stateArray[7]); // B
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[1];

			presentXState = Integer.parseInt("" + stateArray[6]); // C
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[2];
			break;

		case 3:
			presentXState = Integer.parseInt("" + stateArray[7]); // B
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[1];

			presentXState = Integer.parseInt("" + stateArray[6]); // C
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[2];

			presentXState = Integer.parseInt("" + stateArray[4]); // E
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[4];
			break;

		case 4:
			presentXState = Integer.parseInt("" + stateArray[8]); // A
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[0];

			presentXState = Integer.parseInt("" + stateArray[5]); // D
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[3];

			presentXState = Integer.parseInt("" + stateArray[2]); // G
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[6];
			break;

		case 5:
			presentXState = Integer.parseInt("" + stateArray[7]); // B
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[1];

			presentXState = Integer.parseInt("" + stateArray[5]); // D
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[3];

			presentXState = Integer.parseInt("" + stateArray[4]); // E
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[4];

			presentXState = Integer.parseInt("" + stateArray[3]); // F
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[5];

			presentXState = Integer.parseInt("" + stateArray[1]); // H
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[7];
			break;

		case 6:
			presentXState = Integer.parseInt("" + stateArray[6]); // C
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[2];

			presentXState = Integer.parseInt("" + stateArray[3]); // F
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[5];

			presentXState = Integer.parseInt("" + stateArray[0]); // I
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[8];
			break;

		case 7:
			presentXState = Integer.parseInt("" + stateArray[5]); // D
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[3];

			presentXState = Integer.parseInt("" + stateArray[4]); // E
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[4];

			presentXState = Integer.parseInt("" + stateArray[2]); // G
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[6];

			presentXState = Integer.parseInt("" + stateArray[1]); // H
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[7];
			break;

		case 8:
			presentXState = Integer.parseInt("" + stateArray[2]); // G
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[6];

			presentXState = Integer.parseInt("" + stateArray[1]); // H
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[7];

			presentXState = Integer.parseInt("" + stateArray[0]); // I
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[8];
			break;
		default:
			presentXState = Integer.parseInt("" + stateArray[4]); // E
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[4];

			presentXState = Integer.parseInt("" + stateArray[3]); // F
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[5];

			presentXState = Integer.parseInt("" + stateArray[1]); // H
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[7];

			presentXState = Integer.parseInt("" + stateArray[0]); // I
			targetXState = (presentXState + 1) % 4;
			presentState += (targetXState - presentXState) * powersOfFour[8];
			break;
		}
		return presentState;
	}
}
