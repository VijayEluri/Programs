/*
ID: kasturisa1
LANG: JAVA
PROG: ride
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ride {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"ride.out")));

		String comet = reader.readLine().trim();
		String group = reader.readLine().trim();
		int cometNo = 1, groupNo = 1;
		for (int i = 0, n = comet.length(); i < n; ++i) {
			cometNo *= comet.charAt(i) - 'A' + 1;
			cometNo %= 47;
		}

		for (int i = 0, n = group.length(); i < n; ++i) {
			groupNo = groupNo * (group.charAt(i) - 'A' + 1);
			groupNo %= 47;
		}

		if (cometNo == groupNo) {
			out.println("GO");
		} else {
			out.println("STAY");
		}

		reader.close();
		out.close();

		System.exit(0);
	}
}
