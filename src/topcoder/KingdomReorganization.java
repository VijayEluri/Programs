package topcoder;

import java.util.ArrayList;
import java.util.Collections;

public class KingdomReorganization {
	private class Edge implements Comparable<Edge>{
		int a, b, weight;
		public Edge(int a, int b, int weight) {
			this.a = a;
			this.b = b;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge e) {
			return weight - e.weight;
		}
		
		@Override
		public String toString() {
			return "StartNode: " + a + " endNode: " + b + " weight: " + weight;
		}
	}
	
	public int getValue(char c) {
		final int w;
		if(c < 'a') {	// Will be 'A' to 'Z'
			w = c - 'A';
		} else {
			w = c - 'a' + 26;
		}
		return w;
	}

	public int getCost(String[] kingdom, String[] build, String[] destroy)
	{
		final int numCities = kingdom.length;
		int totalDestroy = 0;
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int i=0; i<numCities-1; ++i) {
			for(int j=i+1; j<numCities; ++j) {
				if(kingdom[i].charAt(j) == '0') {
					final char c = build[i].charAt(j);
					final int w = getValue(c);
					edges.add(new Edge(i, j, w));
				} else {			
					final char c = destroy[i].charAt(j);
					final int w = getValue(c);
					edges.add(new Edge(i, j, -w));
					totalDestroy += w;
				}
			}
		}
		
		Collections.sort(edges);
		int[] colors = new int[numCities];
		for(int i=0; i<numCities; ++i) {
			colors[i] = i;
		}
		
		int mstCost = 0;
		for(int j=0; j<edges.size(); ++j) {
			Edge e = edges.get(j);
			if(colors[e.a] != colors[e.b]) {
				mstCost += e.weight;		
			
				int oldColor = colors[e.b], newColor = colors[e.a];
				for(int i=0; i<numCities; ++i) {
					if(colors[i] == oldColor) {
						colors[i] = newColor;
					}
				}
			}
		}
		return totalDestroy + mstCost;
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		

		time = System.currentTimeMillis();
		answer = new KingdomReorganization().getCost(new String[]{"000","000","000"}, new String[]{"ABD","BAC","DCA"}, new String[]{"ABD","BAC","DCA"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 3;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new KingdomReorganization().getCost(new String[]{"011","101","110"}, new String[]{"ABD","BAC","DCA"}, new String[]{"ABD","BAC","DCA"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new KingdomReorganization().getCost(new String[]{"011000","101000","110000","000011","000101","000110"}, new String[]{"ABDFFF","BACFFF","DCAFFF","FFFABD","FFFBAC","FFFDCA"}, new String[]{"ABDFFF","BACFFF","DCAFFF","FFFABD","FFFBAC","FFFDCA"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 7;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new KingdomReorganization().getCost(new String[]{"0"}, new String[]{"A"}, new String[]{"A"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 0;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new KingdomReorganization().getCost(new String[]{"0001","0001","0001","1110"}, new String[]{"AfOj","fAcC","OcAP","jCPA"}, new String[]{"AWFH","WAxU","FxAV","HUVA"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 0;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new KingdomReorganization().getCost(new String[]{"0000000000","0000000011","0001010000","0010010000","0000001000","0011000000","0000100000","0000000011","0100000101","0100000110"}, new String[]{"AhPEqkSFMM","hAfKPtsDad","PfAyGQkaqN","EKyAeLpRpm","qPGeASfNwo","ktQLSAnCAK","SskpfnAdJS","FDaRNCdAZz","MaqpwAJZAn","MdNmoKSznA"}, new String[]{"AgTqWWxEYH","gAXPgjzIRA","TXAleTmWvT","qPlAQkwxRO","WgeQAqgbJJ","WjTkqAiTzl","xzmwgiAuHb","EIWxbTuAwk","YRvRJzHwAn","HATOJlbknA"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 65;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();

		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
