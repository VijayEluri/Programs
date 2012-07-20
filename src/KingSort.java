import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class KingSort {
	public String[] romans = new String[]{"I",
			"II",
			"III",
			"IV",
			"V",
			"VI",
			"VII",
			"VIII",
			"IX",
			"X",
			"XI",
			"XII",
			"XIII",
			"XIV",
			"XV",
			"XVI",
			"XVII",
			"XVIII",
			"XIX",
			"XX",
			"XXI",
			"XXII",
			"XXIII",
			"XXIV",
			"XXV",
			"XXVI",
			"XXVII",
			"XXVIII",
			"XXIX",
			"XXX",
			"XXXI",
			"XXXII",
			"XXXIII",
			"XXXIV",
			"XXXV",
			"XXXVI",
			"XXXVII",
			"XXXVIII",
			"XXXIX",
			"XL",
			"XLI",
			"XLII",
			"XLIII",
			"XLIV",
			"XLV",
			"XLVI",
			"XLVII",
			"XLVIII",
			"XLIX",
			"L",};
	public HashMap<String, Integer> romanToInt;

	public static void main(String[] args) {
		KingSort k = new KingSort();
		System.out.println(Arrays.toString(k.getSortedList(new String[]{"Philippe II", "Philip II"})));
	}

	public String[] getSortedList(String[] kings) {
		romanToInt = new HashMap<String, Integer>(romans.length);
		for(int i=1, n=romans.length; i<=n; ++i) {
			romanToInt.put(romans[i-1], i);
		}
		Arrays.sort(kings, new Comparator<String>() {
			@Override
			public int compare(String king1, String king2) {
				final String[] king1Arr = king1.split(" ");
				final String[] king2Arr = king2.split(" ");
				final int actualComparison = king1Arr[0].compareTo(king2Arr[0]);
				if(actualComparison != 0) {
					return actualComparison; 
				} else {
					// Both have same actual name, compare ordinal
					return romanToInt.get(king1Arr[1]) - romanToInt.get(king2Arr[1]);
				}
			}
		});
		return kings; 
	}
}