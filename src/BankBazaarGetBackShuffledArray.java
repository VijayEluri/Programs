import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BankBazaarGetBackShuffledArray {
    private static final BufferedReader STDIN = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new BankBazaarGetBackShuffledArray().execute();
    }

    // Write your entire logic in here
    private void execute() throws Exception {
        for (String[] lineComponents = readLine(); lineComponents != null; lineComponents = readLine()) {
        	if(lineComponents.length < 1) continue;
        	
        	// Read and store input
        	final int N = Integer.parseInt(lineComponents[0]);
        	final boolean[] valid = new boolean[N];
        	Arrays.fill(valid, true);
        	final int[] A = new int[N];
        	final int[] B = new int[N];
        	for(int i=1; i<N+1; ++i) {
        		B[i-1] = Integer.parseInt(lineComponents[i]);
        	}
//        	System.out.println(Arrays.toString(B));
        	
        	// Execute the algo
        	int numberToInsert = N;
        	while(numberToInsert > 0) { 
        		for(int i=0; i<N; ++i) {
        			if(valid[i] && B[i] == 0) {
        				// Insert the next val here. 
        				valid[i] = false;
        				for(int j=0; j<i; ++j) {
        					if(valid[j] && B[j] > 0) {
        						B[j]--;
        					}
        				}
        				A[i] = numberToInsert;
        				break;
        			}
        		}
        		--numberToInsert;
        	}
//        	System.out.println(Arrays.toString(A));
        	for(int i = 0; i < N; ++i) {
        		System.out.print(A[i]);
        		if(i == N-1) {
        			System.out.print("\n");
        		} else {
        			System.out.print(" ");
        		}
        	}
        }
        
    }

    private String[] readLine() throws IOException {
        String line = STDIN.readLine();
        return line != null ? line.split(" ") : null;
    }

    private int toInteger(String str) {
        return Integer.parseInt(str);
    }

    private long toLong(String str) {
        return Long.parseLong(str);
    }

    private void println(String str) {
        System.out.println(str);
    }

    private void print(String str) {
        System.out.print(str);
    }
}
