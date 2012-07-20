public class PairingPawns {
	public  int savedPawnCount(int[] start) {
		final int len = start.length;
		if(len < 1) {
			return 0;
		} else {
			for(int i=len-1; i>0; --i) {
				start[i-1] += start[i] / 2;
			}
			return start[0];
		}
	}
	
	public static void main(String[] args) {
		PairingPawns p = new PairingPawns();
		System.out.println(p.savedPawnCount(new int[]{1000,2000,3000,4000,5000,6000,7000,8000}));
	}
}
