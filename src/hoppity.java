import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class hoppity {
	public static void main(String[] args) throws IOException {
		if (args.length == 1) {
			Scanner in = new Scanner(new File(args[0]));
			int n = in.nextInt();
			

			for (int i = 1; i <= n; i++) {
				if ((i % 3 == 0) && (i % 5 == 0))
					System.out.println("Hop");
				else if (i % 3 == 0)
					System.out.println("Hoppity");
				else if (i % 5 == 0)
					System.out.println("Hophop");
			}
		}
	}
}