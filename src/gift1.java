/*
ID: kasturisa1
LANG: JAVA
PROG: gift1
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class gift1 {
	public static void main(String[] args) throws IOException {
		Map<String, Integer> moneyDetails = new HashMap<String, Integer>();
		BufferedReader reader = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"gift1.out")));
		int noOfPeople = Integer.parseInt(reader.readLine().trim());

		String tempStr;
		String[] people = new String[noOfPeople];
		for (int i = 0; i < noOfPeople; i++) {
			tempStr = reader.readLine().trim();
			people[i] = tempStr;
			moneyDetails.put(tempStr, 0);
		}

		Map<String, Integer> initialMoneyDetails = new HashMap<String, Integer>();
		
		StringTokenizer st;
		int initialMoney = 0, noOfPersonsToGift = 0;
		String presentPerson;
		String personGettingGift;
		while ((presentPerson = reader.readLine()) != null) {
			st = new StringTokenizer(reader.readLine());
			initialMoney = Integer.parseInt(st.nextToken());
			initialMoneyDetails.put(presentPerson, initialMoney);
			noOfPersonsToGift = Integer.parseInt(st.nextToken());
			if (noOfPersonsToGift != 0) {
				int moneyGiftedPerPerson = initialMoney / noOfPersonsToGift;
				for (int j = 0; j < noOfPersonsToGift; ++j) {
					personGettingGift = reader.readLine().trim();
					Integer personGettingGiftsMoney = moneyDetails
							.get(personGettingGift);
					personGettingGiftsMoney += moneyGiftedPerPerson;
					moneyDetails.remove(personGettingGift);
					moneyDetails
							.put(personGettingGift, personGettingGiftsMoney);
				}
				Integer presentMoney = moneyDetails
						.get(presentPerson);
				moneyDetails.remove(presentPerson);
				moneyDetails.put(presentPerson, presentMoney
						+ (initialMoney % noOfPersonsToGift));
			} else {
				Integer presentMoney = moneyDetails
						.get(presentPerson);
				moneyDetails.remove(presentPerson);
				moneyDetails.put(presentPerson, presentMoney + initialMoney);
			}

		}
		reader.close();
		for (int i = 0; i < noOfPeople; i++) {
			out.print(people[i]);
			out.print(" ");
			out.print(((Integer) moneyDetails.get(people[i]))
					- ((Integer) initialMoneyDetails.get(people[i])));
			out.print("\n");
		}		
		out.close();		
		System.exit(0);
	}
}
