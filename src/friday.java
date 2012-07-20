/*
: kasturisa1
LANG: JAVA
TASK: friday
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class friday {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("friday.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		int year = Integer.parseInt(reader.readLine().trim());
		reader.close();
		year = 1900 + year;

		int noOfDaysInMonths[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int days[] = new int[7];
		for (int i = 0; i < 7; i++) {
			days[i] = 0;
		}
		// Monday - 0
		int date;
		short presentDay = 0;
		int noOfDaysInMonth = 0;
		boolean leapYearFlag = false;
		for (int presentYear = 1900; presentYear < year; ++presentYear) {
			leapYearFlag = false;
			if (presentYear % 4 == 0) {
				leapYearFlag = true;
				if (presentYear % 100 == 0 && presentYear % 400 != 0)
					leapYearFlag = false;
			}

			for (int presentMonth = 1; presentMonth <= 12; ++presentMonth) {
				if (presentMonth == 2) {
					if (leapYearFlag) {
						noOfDaysInMonth = 29;
					} else
						noOfDaysInMonth = 28;
				} else {
					noOfDaysInMonth = noOfDaysInMonths[presentMonth - 1];
				}

				for (date = 1; date <= noOfDaysInMonth; date++) {
					if (date == 13) {
						++days[presentDay];
					}
					++presentDay;
					presentDay %= 7;	 
				}

			}
		}

		writer.write(days[5] + " " + days[6] + " " + days[0] + " " + days[1] + " " + days[2] + " " + days[3] + " " + days[4]+"\n");
		writer.close();
		System.exit(0);
		
	}
}
