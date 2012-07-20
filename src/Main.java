import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try {
			BufferedReader inputReader = new BufferedReader(
					new InputStreamReader(System.in));

			int noOfTestCases = Integer.parseInt(inputReader.readLine().trim());
			int power = 1, present = 0;
			for (int i = 0; i < noOfTestCases; ++i) {
				power = 1;
				present = Integer.parseInt(inputReader.readLine().trim());
				while (present != 1) {
					present /= 2;
					power = power << 1;
					}
				System.out.println(power);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}