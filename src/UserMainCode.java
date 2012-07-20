import java.io.*;
import java.util.Arrays;

public class UserMainCode {
	// Assume following return types while writing the code for this question.
	public static int output1;

	public static void GetMinimumSum(int[] input1) {
		if(input1.length <= 0) {
			return;
		}
		Arrays.sort(input1);
		int overallSum = 0;
		for(int input : input1) {
			overallSum += input;
		}
		
		// Start at the 2nd largest number
		int idx = input1.length - 1;
		output1 = overallSum;
		while(output1 >= 0 && idx >= 0) {
			final int nextSum = output1 - 2*input1[idx];
			if(nextSum >= 0) {
				output1 = nextSum;
				System.out.println("Reversing sign of " +  input1[idx]);
			}
			--idx;
		}
	}
	
	

	public static void main(String[] args) {
//		GetMinimumSum(new int[]{2,2,4,5,6});
//		System.out.println(output1);
		System.out.println(1000000 / 1000d / 2);
	}
}
