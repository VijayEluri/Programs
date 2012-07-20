


import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
/**
 * @author sasik
 * 
 */
public class milk2 {
	/**
	 * @uml.property  name="timings" multiplicity="(0 -1)" dimension="2"
	 */
	int timings[][];

	/**
	 * @uml.property  name="noFar"
	 */
	int noFar;

	/**
	 * @uml.property  name="ftimings" multiplicity="(0 -1)" dimension="2"
	 */
	int ftimings[][];

	public static void main(String[] args) throws IOException {
		milk2  m = new milk2();
		m.readInput();
		int ret[] = m.processInput();
//		System.out.println(Arrays.toString(ret));
		PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));	
		w.append(Integer.toString(ret[0]));
		w.append(" ");
		w.append(Integer.toString(ret[1]));
		w.append("\n");
		w.close();
	}

	public void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milk2.in"));
		noFar = Integer.parseInt(br.readLine());
		timings = new int[noFar][2];
		for (int i = 0; i < noFar; ++i) {
			final StringTokenizer st = new StringTokenizer(br.readLine());
			timings[i][0] = Integer.parseInt(st.nextToken());
			timings[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}

	public int[] processInput() {
		/* Sort based on start time */
		int s = 0, e = 0, minInd = 0, minS = 0;
		for (int i = 0; i < noFar - 1; ++i) {
			minS = timings[i][0]; minInd = i;
			for (int j = i+1; j < noFar; j++) {
				if (minS > timings[j][0]) {
					minS = timings[j][0];
					minInd = j;
				}
			}			
			/* Swap */
			s = timings[i][0]; e = timings[i][1];
			timings[i][0] = timings[minInd][0]; timings[i][1] = timings[minInd][1];
			timings[minInd][0] = s; timings[minInd][1] = e;
		}			
		
		ftimings = new int[noFar][2];
			
		s =  e = timings[0][1];
		int ind = 0; 
		ftimings[ind][0] = timings[0][0]; ftimings[0][1] = timings[0][1];
		for(int i=1; i<noFar; i++) {
			if(ftimings[ind][1] >= timings[i][0]) {
				if(ftimings[ind][1] < timings[i][1]) 
					ftimings[ind][1] = timings[i][1];
			} else {
				ind++;
				ftimings[ind][0] = timings[i][0]; ftimings[ind][1] = timings[i][1];				
			}
		}
//		System.out.println("Timings");
//		for(int[] x : timings) 
//			System.out.println(Arrays.toString(x));
	
//		System.out.println("FTimings");		
//		for(int[] x : ftimings) 
//				System.out.println(Arrays.toString(x));
		
//		System.out.println("Ind: " + ind);
		int minBusy = ftimings[0][1] - ftimings[0][0], minIdle = 0;
		if(ind != 0) 
		{		
			for(int i=0; i < ind ; ++i) {
				minIdle = (ftimings[i+1][0] - ftimings[i][1]) > minIdle ? ftimings[i+1][0] - ftimings[i][1] : minIdle;				
				minBusy = ftimings[i][1] - ftimings[i][0] > minBusy ? ftimings[i][1] - ftimings[i][0] : minBusy; 				
			}				
		}
		
		minBusy = ftimings[ind][1] - ftimings[ind][0] > minBusy ? ftimings[ind][1] - ftimings[ind][0] : minBusy; 
		
		
		int ret[] = new int[2];
		ret[0] = minBusy;
		ret[1] = minIdle;
		return ret; 
//		return null;
	}
}
