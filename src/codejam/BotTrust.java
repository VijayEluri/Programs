package codejam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class BotTrust {

	public static void main(String[] args) {
		String fileName = "/home/sasik/Desktop/input";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String[] line = reader.readLine().split(" ");
			int noOfSteps = Integer.parseInt(line[0]);

			int testCaseNo = 0;

			testCaseNo = 1;
			int steps = 0;
			int O = 1;
			int B = 1;

			int targetPos = 0;
			for (int i = 0; i < noOfSteps; i++) {
				
			}

			System.out.println("Case #" + testCaseNo + ": " + steps);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
