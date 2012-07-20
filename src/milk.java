/*
 ID: kasturisa1
 LANG: JAVA
 TASK: milk 
*/
import java.io.*;
import java.util.*;
import java.text.*;

public class milk {
	public class FarmerSupply {
		public int price; public int quantity;
	}

	private FarmerSupply farmerSupplies[]; 
	private int milkNeeded, noOfFarmers;
	public milk() {
		farmerSupplies = null;
		milkNeeded = noOfFarmers = 0;
	}
	
	public void readInput() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milk.in"));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		this.milkNeeded = Integer.parseInt(st1.nextToken()); this.noOfFarmers = Integer.parseInt(st1.nextToken());
		this.farmerSupplies = new FarmerSupply[noOfFarmers];		
		for(int i=0; i<noOfFarmers; ++i) {
			final StringTokenizer st = new StringTokenizer(br.readLine());
			farmerSupplies[i] = new FarmerSupply();
			farmerSupplies[i].price = Integer.parseInt(st.nextToken()); farmerSupplies[i].quantity = Integer.parseInt(st.nextToken());
		}
		br.close();
	}

	public void process() throws IOException {
		PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		if(milkNeeded == 0) {
			w.append("0\n"); w.close();
			return;
		}
		/* Sort the farmers based on the price */
		Arrays.sort(farmerSupplies, new Comparator<FarmerSupply> () {
			@Override
			public int compare(FarmerSupply e1, FarmerSupply e2) {
				if( e1.price > e2.price) return 1;
				if( e1.price < e2.price) return -1;
				return 0;
			}
		});
		int priceToCompany = 0, remQuantity = milkNeeded; 
		for(FarmerSupply x : farmerSupplies) {			
			if( remQuantity >= x.quantity) {
				priceToCompany += x.quantity * x.price;
				remQuantity -= x.quantity;				
			} else {
				priceToCompany += remQuantity * x.price;
				break;
			}
		}
		w.append(priceToCompany + "\n");
		w.close();
		
	}
	

	public static void main(String[] args) throws IOException {
		milk m = new milk();
		m.readInput();
		m.process();
	} 
}
