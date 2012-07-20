import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumsInTriangle {
	/**
	 * @uml.property  name="arr" multiplicity="(0 -1)" dimension="2"
	 */
	int[][] arr;

	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int noOfTestCases;
		try {
			noOfTestCases = Integer.parseInt(reader.readLine().trim());
			int lines = 0;
			String[] temp;
			for (int i = 0; i < noOfTestCases; ++i) {
				// System.out.println("Test case no: " + (i + 1));
				lines = Integer.parseInt(reader.readLine().trim());
				// System.out.println("Present number of lines: " + lines);
				arr = new int[lines][lines];
				// Input read
				for (int j = 0; j < lines; j++) {
					temp = reader.readLine().trim().split(" ");
					for (int l = 0; l <= j; l++) {
						arr[j][l] = Integer.parseInt(temp[l]);
						// System.out.println("Row: " + (j + 1) + " Column: "
						// + (l + 1) + " Value: " + arr[j][l]);
					}
				}

				for (int j = lines - 2; j > -1; --j) {
					for (int l = 0; l <= j; ++l) {
						arr[j][l] += Math.max(arr[j+1][l], arr[j+1][l+1]);
					}
				}
				System.out.println(arr[0][0]);

			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
