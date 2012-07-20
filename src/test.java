/*
ID: kasturisa1
LANG: JAVA
TASK: test
 */
import java.io.File;
import java.io.IOException;

class test {
	public static void main(String[] args) throws IOException {
//		char name[] = new char[6];
		
//		for(int i=1000000; i> 100000; --i) {
//			String s =  Integer.toString(i, 16);
//			final int len = s.length();
//			int index = name.length - len;
//			for(char ch : s.toCharArray()) {
//				name[index++] = ch;
//			}
//		}
		
		final File f = new File("/home/sasik/");
		System.out.println(f.getAbsolutePath());
	}
}
