import java.util.Arrays;

public class MinskyMysteryDiv2 {
	final long[] bags = new long[5];

	public static void main(String[] args) {
		MinskyMysteryDiv2 m = new MinskyMysteryDiv2();
		for(int i=2; i<100; ++i) {
			System.out.println(m.computeAnswer(i));
		}
	}
	
	public long computeAnswer(long N) {
		bags[0] = N;
		boolean flag = true;
		while(flag) {
//			System.out.println("A" + Arrays.toString(bags));
			++bags[1];
			while(flag) {
				++bags[1];
				bags[4] = 0;
//				System.out.println("B" + Arrays.toString(bags));
				while(bags[0] != 0) {
					while(bags[0] != 0 && bags[1] != 0) {
						--bags[0]; 
						--bags[1];
						++bags[2];
						++bags[3];
					}
//					System.out.println("C" + Arrays.toString(bags));
					++bags[4];
					if(bags[0] == 0 && bags[1] == 0) {
						return bags[4] + bags[3];					
					}
					bags[1] += bags[3];
					bags[3] = 0;
//					System.out.println("D" + Arrays.toString(bags));
				}
				bags[0] += bags[2];
				bags[2] = 0;
			}
		}
		return 0;
	}
}
