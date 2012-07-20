package interviewstreet;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class CollapsingFeeds {
	private class Task {
		int parent = -1;
		int taskId;
		ArrayList<Integer> empIds = new ArrayList<Integer>();
		int responseEmployeeId = -1;
		
		@Override
		public String toString() {
			StringBuffer s = new StringBuffer();
			s.append(taskId);
			s.append(":");
			if(responseEmployeeId != -1) { // completed
				s.append("Completed");
				s.append(":");
				s.append(responseEmployeeId);
			} else {
				s.append("InComplete");
			}
			s.append(":");
			
			Collections.sort(empIds);
			for(int empId : empIds) {
				s.append(empId);
				s.append(":");
			}
			return s.substring(0, s.length() - 1);
		}
	}
	
	public void run() throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int MAXIDS = 2000;
		boolean[] valid = new boolean[MAXIDS];
		while(true) {
			try {
				
			} catch(EOFException eofx) {
				break;
			}
		}
	}
}
