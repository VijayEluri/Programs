package interviewstreet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class PowerSources {
	int[][] graph;
	int N;
	int[] volatality;
	int[][] pathLength;
	ArrayList< HashSet<Integer> > invalid; 
	public PowerSources() throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		volatality = new int[N];
		final StringTokenizer vol = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) {
			volatality[i] = Integer.parseInt(vol.nextToken());
		}
		
		graph = new int[N][N];
		for(int i=0; i<N; ++i) {
			Arrays.fill(graph[i], Integer.MAX_VALUE);
		}
		for(int i=0; i<N-1; ++i) {
			final StringTokenizer edge = new StringTokenizer(br.readLine());
			final int a = Integer.parseInt(edge.nextToken());
			final int b = Integer.parseInt(edge.nextToken());	
			
			graph[a-1][b-1] = graph[b-1][a-1] = 1; 
		}
		
		pathLength = graph.clone();
		for(int i=0; i<N; ++i) {
			pathLength[i][i] = 0;
		}
		
		// Do all pairs shortest path
		for(int k=0; k<N; ++k) {
			for(int i=0; i<N; ++i) {
				for(int j=0; j<N; ++j) {
					if(pathLength[i][k] != Integer.MAX_VALUE && pathLength[k][j] != Integer.MAX_VALUE && pathLength[i][j] > pathLength[i][k] + pathLength[k][j]) {
						pathLength[i][j] = pathLength[i][k] + pathLength[k][j];
					}
				}
			}
		}
		
		// Pre-process to obtain valid entries invalid entries
		invalid = new ArrayList< HashSet<Integer> >(N);
		for(int i=0; i<N; ++i) {
			invalid.add(new HashSet<Integer>());
		}
	}
	
	public int run() {
		final boolean[] placed = new boolean[N];
		Arrays.fill(placed, false);
		return simpleDp(N - 1, placed);
	}
	
	HashMap<Integer, Integer> simplerDpTable = new HashMap<Integer, Integer>();	
	private int simpleDp(int position, boolean[] placedPositions) {
		if(position == 0) {
			boolean canPlace = true;
			for(int i=0; i<N; ++i) {
				if( i!= position && placedPositions[i] && pathLength[position][i] <= Math.max(volatality[i], volatality[position])) {
					canPlace = false;
				}
			}
			if(canPlace) {
				return 1;
			} else {
				return 0;
			}
		} else {
			// not placed
			boolean[] next = placedPositions.clone();
			int without = simpleDp(position - 1, next), with = Integer.MIN_VALUE;
			// can place
			boolean canPlace = true;
			for(int i=0; i<N; ++i) {
				if(i!= position && placedPositions[i] && pathLength[position][i] <= Math.max(volatality[i], volatality[position])) {
					canPlace = false;
				}
			}
			
			if(canPlace) {
				next[position] = true;
				with = 1 + simpleDp(position - 1, next);
			}
			return Math.max(without, with);
		}
	}
	
	
	
	private int oldVer(int position, ArrayList<Integer> placedPositions) {
		if(position == 0) {
			boolean canPlace = true;
			for(int place : placedPositions) {
				if(pathLength[position][place] <= Math.max(volatality[place], volatality[position])) {
					canPlace = false;
				}
			}
			if(canPlace) {
				return 1;
			} else {
				return 0;
			}
		} else {
			// not placed
			ArrayList<Integer> next = (ArrayList<Integer>)placedPositions.clone();
			int without = oldVer(position - 1, next), with = Integer.MIN_VALUE;
			// can place
			boolean canPlace = true;
			for(int place : placedPositions) {
				if(pathLength[position][place] <= Math.max(volatality[place], volatality[position])) {
					canPlace = false;
				}
			}
			if(canPlace) {
				next.add(position);
				with = 1 + oldVer(position - 1, next);
			}
			return Math.max(without, with);
		}
	}
	
	
	HashMap< HashMap<Integer, HashSet<Integer> >, Integer > dpTable = new HashMap< HashMap< Integer,HashSet< Integer > >, Integer>();
	private int dp(int position, HashSet<Integer> placedPositions) {
		HashMap<Integer, HashSet<Integer> > key = new HashMap<Integer, HashSet<Integer> >();
		key.put(position, placedPositions);
		if(dpTable.containsKey(key)) {
			return dpTable.get(key);
		}
		
		if(position == 0) {
			boolean canPlace = true;
			for(int place : placedPositions) {
				if(pathLength[position][place] <= Math.max(volatality[place], volatality[position])) {
					canPlace = false;
				}
			}			
			if(canPlace) {
				dpTable.put(key, 1);
				return 1;
			} else {
				dpTable.put(key, 0);
				return 0;
			}
		} else {
			// not placed
			HashSet<Integer> next = (HashSet<Integer>) placedPositions.clone(), next1 = (HashSet<Integer>) placedPositions.clone(); 
			key = new HashMap<Integer, HashSet<Integer>>();
			key.put(position, next);
			int without = dp(position - 1, next), with = Integer.MIN_VALUE;
			dpTable.put(key, without);
			// Can place
			boolean canPlace = true;
			for(int place : placedPositions) {
				if(pathLength[position][place] <= Math.max(volatality[place], volatality[position])) {
					canPlace = false;
				}
			}
			if(canPlace) {
				next1.add(position);
				with = 1 + dp(position - 1, next1);
				key = new HashMap<Integer, HashSet<Integer>>();
				key.put(position, next1);
				dpTable.put(key, with);
			}
			return Math.max(without, with);
		}
	}
	
	public static void main(String[] args) throws Exception {
		PowerSources p = new PowerSources();
		System.out.println(p.run());
	}
		
}
