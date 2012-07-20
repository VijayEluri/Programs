package facebook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AlphabetSoup {

	public static void main(String[] args) throws Exception {
		AlphabetSoup a = new AlphabetSoup("/home/sasidhark/Downloads/alphabet_soup.txt");
		a.run();
	}

	final char testCases[][];
	final String fileName; 

	public AlphabetSoup(String fileName) throws Exception {
		this.fileName = fileName;
		final BufferedReader b = new BufferedReader(new FileReader(new File(fileName)));
		final int numTestCases = Integer.parseInt(b.readLine());
		testCases = new char[numTestCases][];
		for (int i = 0; i < numTestCases; ++i) {
			testCases[i] = b.readLine().toCharArray();
			// System.out.println(Arrays.toString(testCases[i]));
		}
	}

	public void run() {
		final float count[] = new float[8];
		for (int t = 0, n = testCases.length; t < n; ++t) {
			Arrays.fill(count, 0f);
			for (int i = 0, l = testCases[t].length; i < l; ++i) {
				switch (testCases[t][i]) {
				case 'H':
					++count[0];
					break;
				case 'A':
					++count[1];
					break;
				case 'C':
					count[2] += 0.5f;
					break;
				case 'K':
					++count[3];
					break;
				case 'E':
					++count[4];
					break;
				case 'R':
					++count[5];
					break;
				case 'U':
					++count[6];
					break;
				case 'P':
					++count[7];
					break;
				default:
					break;
				}
			}
			int min = Integer.MAX_VALUE;
			for (int m = 0, k = count.length; m < k; ++m) {
				if (min > count[m]) {
					min = (int) count[m];
				}
			}
			System.out.println("Case #" + (t + 1) + ": " + min);
		}
	}
}
