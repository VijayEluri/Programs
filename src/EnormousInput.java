import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnormousInput {
	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String[] nk;
		try {
			nk = reader.readLine().split(" ");

			int n = Integer.parseInt(nk[0]);
			int k = Integer.parseInt(nk[1]);
			int result = 0;
			for (int i = 0; i < n; i++) {
				if (Integer.parseInt(reader.readLine()) % k == 0)
					result++;
			}
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
