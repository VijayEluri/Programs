import java.util.HashSet;

public class DengklekTryingToSleep {

	public int minDucks(int[] ducks) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<ducks.length; ++i) {
			if(min > ducks[i]) {
				min = ducks[i];
			}
			if(max < ducks[i]) {
				max = ducks[i];
			}
		}
		final HashSet<Integer> nums = new HashSet<Integer>();
		for(int num : ducks) {
			nums.add(num);
		}
		return (max - min + 1) - nums.size();
	}
	
	public static void main(String[] args) {
		DengklekTryingToSleep d = new DengklekTryingToSleep();
		System.out.println(d.minDucks(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
	}
}
