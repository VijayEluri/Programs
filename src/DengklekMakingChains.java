import java.util.Arrays;

public class DengklekMakingChains {

	public int maxBeauty(String[] chains) {
		final int numChains = chains.length;
		boolean[] isChainUsed = new boolean[numChains];
		Arrays.fill(isChainUsed, false);
		int presentVal = 0;
		final StringBuilder presentChain = new StringBuilder();
		while (true) {
			boolean leftValid = true, rightValid = true;
			int maxIdx = -1;
			int maxVal = Integer.MIN_VALUE;
			for (int i = 0; i < numChains; ++i) {
				if (!isChainUsed[i]) {
					if (maxIdx != -1) {
						final int val = getValue(chains[i]);
						if(val > maxVal) {
							maxIdx = i;
							maxVal = val;
						}
					}
				}
			}
			
			if(maxIdx != -1) {
				
			}
		}
	}

	private int getValue(String s) {
		int value = 0;
		for (char c : s.toCharArray()) {
			if (c != '.') {
				value += c - '0';
			}
		}
		return value;
	}

	public static void main(String[] args) {

	}

}
