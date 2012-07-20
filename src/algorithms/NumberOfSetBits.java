package algorithms;

public class NumberOfSetBits {
	public static int getNumberOfSetBits(int n) {
		int result = 0;
		for(int i=0; i<n; ++i) {
			if((n & (1 << i)) != 0) {
				++result;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		final int l = 4;
		for(int i=1; i< (1 << l); ++i) {
			System.out.println(getNumberOfSetBits(i) + "\t" + getNumberOfSetBits(i-1) + "\t" + (i & (i-1)));
		}
	}
}
