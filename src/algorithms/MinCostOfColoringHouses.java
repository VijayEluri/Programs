package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * There are N houses in a row. Each house can be painted in either Red, Green
 * or Blue color. The cost of coloring each house in each of the colors is
 * different.
 * 
 * Find the color of each house such that no two adjacent house have the same
 * color and the total cost of coloring all the houses is minimum.
 * 
 * @author sasik 
 */

public class MinCostOfColoringHouses {
	final int numHouses;
	final int numColors;
	public static final int MAX_COST = 100; 
	int cost[][];	
	
	public MinCostOfColoringHouses() {
		numHouses = 100;
		numColors = 100;
		initializeCostRandomly();
	}
	
	public void initializeCostRandomly() {
		Random r = new Random();
		cost = new int[numHouses][numColors];
		for(int i=0; i<numHouses; ++i) {
			for(int j=0; j<numColors; ++j) {
				cost[i][j] = Math.abs(r.nextInt()) % MinCostOfColoringHouses.MAX_COST;				
			}
		}
	}
	
	public int getMinCost() {
		final int[][] dpTable = new int[numHouses][numColors];
		for(int i=0; i<numColors; ++i) {
			dpTable[0][i] = cost[0][i];
		}
		
		for(int house = 1; house < numHouses; ++house) {
			for(int color = 0; color < numColors; ++color) {
				int minCost = Integer.MAX_VALUE;
				for(int c = 0; c < numColors; ++c) {
					if(c == color) {
						continue;
					}						
					final int presentCost = dpTable[house - 1][c] + cost[house][color];
					minCost = Math.min(presentCost, minCost);
				}
				dpTable[house][color] = minCost;
			}			
		}
		
		int minCost = Integer.MAX_VALUE;
		for(int color = 0; color < numColors; ++color) {
			minCost = Math.min(minCost, dpTable[numHouses - 1][color]);
		}
		System.out.println("COST TABLE");
		for(int house = 0; house < numHouses; ++house) {
			System.out.println("House:" + (house+1) + "\t" + Arrays.toString(cost[house]));
		}
		System.out.println("DPTABLE");
		for(int house = 0; house < numHouses; ++house) {
			System.out.println("House:" + (house+1) + "\t" + Arrays.toString(dpTable[house]));
		}
		
		final int overallMinCost = minCost;
		HashMap<Integer, Integer> houseColors = new HashMap<Integer, Integer>();
		int prevColor = -1;
		//Find out which colors from the dpTable		
		for(int house = numHouses-1; house >= 0; --house) {
			for(int i=0; i<numColors; ++i) {
				if(i!= prevColor && dpTable[house][i] == minCost) {
					houseColors.put(house, i);
					prevColor = i;
					break;
				}
			}
			minCost -= cost[house][houseColors.get(house)];
		}
		for(int key : houseColors.keySet()) {
			System.out.println("House:" + key + " color:" + houseColors.get(key) + " cost:" + cost[key][houseColors.get(key)]);
		}
		return overallMinCost;
	}	
	
	public static void main(String[] args) {
		MinCostOfColoringHouses m = new MinCostOfColoringHouses();
		m.initializeCostRandomly();
		System.out.println(m.getMinCost());
	}
}
