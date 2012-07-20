
import java.io.*;
import java.util.*;
import java.text.*;

/*
 ID: kasturisa1
 LANG: JAVA
 TASK: namenum 
 */

/**
 * @author sasik
 * 
 */
public class namenum {
	/**
	 * @uml.property  name="dict"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.String"
	 */
	HashSet<String> dict;
	/**
	 * @uml.property  name="no"
	 */
	Long no;
	/**
	 * @uml.property  name="results"
	 * @uml.associationEnd  multiplicity="(0 -1)" ordering="true" elementType="java.lang.String" qualifier="key:java.lang.Long java.util.HashSet"
	 */
	HashMap<Long, HashSet<String>> results;
	/**
	 * @uml.property  name="mobKey"
	 * @uml.associationEnd  qualifier="valueOf:java.lang.Character java.lang.Integer"
	 */
	HashMap<Character, Integer> mobKey;

	public static void main(String[] args) throws IOException {
		namenum nn = new namenum();
		nn.readInput();
		nn.process();
	}

	public namenum() {
		/* Initialize counts */
		results = new HashMap<Long, HashSet<String>>();
		/* Initialize mob key */
		mobKey = new HashMap<Character, Integer>();
		mobKey.put('A', 2);		mobKey.put('B', 2);		mobKey.put('C', 2);
		mobKey.put('D', 3);		mobKey.put('E', 3);		mobKey.put('F', 3);
		mobKey.put('G', 4);		mobKey.put('H', 4);		mobKey.put('I', 4);
		mobKey.put('J', 5);		mobKey.put('K', 5);		mobKey.put('L', 5);
		mobKey.put('M', 6);		mobKey.put('N', 6);		mobKey.put('O', 6);
		mobKey.put('P', 7);		mobKey.put('R', 7);		mobKey.put('S', 7);
		mobKey.put('T', 8);		mobKey.put('U', 8);		mobKey.put('V', 8);
		mobKey.put('W', 9);		mobKey.put('X', 9);		mobKey.put('Y', 9);
	}

	public void readInput() throws IOException {
		/* Load the dictionary of acceptable words */
		BufferedReader br = new BufferedReader(new FileReader("dict.txt"));
		dict = new HashSet<String>();
		while (true) {
			final String s = br.readLine();
			if (s == null)
				break;
			dict.add(s);
		}
		br = new BufferedReader(new FileReader("namenum.in"));
		no = Long.parseLong(br.readLine());
		br.close();
		HashMap<Integer, Character> dummy = new HashMap<Integer, Character>();
		dummy.put(2, '2');		dummy.put(3, '3');		dummy.put(4, '4');
		dummy.put(5, '5');		dummy.put(6, '6');		dummy.put(7, '7');
		dummy.put(8, '8');		dummy.put(9, '9');
		for (String x : dict) {
			final char[] arr = x.toCharArray();
			boolean acceptable = true;
			for (int i = 0; i < arr.length; i++) {
				try {
					arr[i] = dummy.get(mobKey.get(arr[i]));
				} catch (Exception e) {
					acceptable = false;
					break;
				}
			}
			if (acceptable) {
				// System.out.println("Acceptable: " + x);
				final Long key = Long.parseLong(new String(arr));
				if (results.containsKey(key))
					results.get(key).add(x);
				else {
					HashSet<String> temp = new HashSet<String>();
					temp.add(x);
					results.put(key, temp);
				}
			} else {
				// System.out.println("Unacceptable: " + x);
				acceptable = true;
			}
		}
	}

	public void process() throws IOException {
		PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter(
				"namenum.out")));
		if (!results.containsKey(no)) {
			System.out.println("NONE\n");
			w.append("NONE\n");
		} else {
			Object[] result = results.get(no).toArray();
			Arrays.sort(result);
			for(Object x : result) {
				System.out.println(x);
				w.append(x.toString());
				w.append('\n');
			}
		}
		w.close();
	}

}
