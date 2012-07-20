import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StudiousStudent {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream("input.txt")));

			int noOfTestcases = Integer.parseInt(reader.readLine().trim());
			ArrayList<String> list = new ArrayList<String>();
			StringBuilder build = new StringBuilder();
			for (int i = 0; i < noOfTestcases; i++) {
				list.clear();
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine().trim());
				tokenizer.nextToken();
				while (tokenizer.hasMoreTokens()) {
					list.add(tokenizer.nextToken());
				}
				Object[] finalStrings = list.toArray();
				Arrays.sort(finalStrings);
				for (int j = 0, n = finalStrings.length; j < n; j++) {
					build.append(finalStrings[j]);
				}
				build.append('\n');
			}
			reader.close();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("output.txt")));
			writer.write(build.toString());
			writer.close();
			
			Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
			Transferable transferableText = new StringSelection("Hello");
			board.setContents(transferableText, null);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}

	}

}
