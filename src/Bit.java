public class Bit {
	public static void main(String[] args) {
		int a = 1 << 31;

		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(a >>> 5));
		System.out.println(Integer.toBinaryString(a >> 5));
				
	}
}
