/* http://www.codechef.com/problems/HS08TEST/ */

import java.text.DecimalFormat;
import java.util.Scanner;

public class ATM {
	public void Run() {
		Scanner s = new Scanner(System.in);
		double withDraw = s.nextDouble();
		double balance = s.nextDouble();
		// Check if not possible
		if ((withDraw + 0.5) > balance || ((withDraw % 5) != 0))
			System.out.println(balance);
		else {
			DecimalFormat f = new DecimalFormat("####.##");
			System.out.println(f.format(balance - withDraw - 0.5));
		}
	}
}
