
/*
ID: kasturisa1
LANG: JAVA
TASK: beads
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class beads {

	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(
//				System.in));
		 BufferedReader reader = new BufferedReader(new
		 FileReader("beads.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(
				"beads.out")));

		int noOfBeads = Integer.parseInt(reader.readLine().trim());
		char[] arrNecklace = reader.readLine().trim().toCharArray();
		ArrayList<Character> transform = new ArrayList<Character>();
		int f = 0, b = 0;
		char presentChar = ' ';
		int presentCount = 0, maxCount = 0;
		char tempChar;
		for (int i = 0; i < noOfBeads; i++) {
			presentCount = 0;
			int pos = i;
			do {
				transform.add(arrNecklace[pos]);
				pos++;
				if (pos == noOfBeads)
					pos = 0;
			} while (pos != i);
			// System.out.println(transform);

			presentChar = transform.get(0);
			for (f = 0; f < noOfBeads; f++) {
				tempChar = transform.get(f);
				if (tempChar == 'w')
					presentCount++;
				else if (presentChar == 'w') {
					presentChar = tempChar;
					presentCount++;
				} else if (presentChar == tempChar) {
					presentCount++;
				} else
					break;
			}

			presentChar = transform.get(noOfBeads - 1);
			for (b = noOfBeads - 1; b >= f; b--) {
				tempChar = transform.get(b);
				if (tempChar == 'w')
					presentCount++;
				else if (presentChar == 'w') {
					presentChar = tempChar;
					presentCount++;
				} else if (presentChar == tempChar) {
					presentCount++;
				} else
					break;
			}

			transform.clear();
			if (maxCount < presentCount)
				maxCount = presentCount;
		}

//		System.out.println(maxCount);
		 writer.write(maxCount + "\n");
		 writer.close();
		System.exit(0);
	}
}
