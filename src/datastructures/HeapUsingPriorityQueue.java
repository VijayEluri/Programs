package datastructures;

import java.util.PriorityQueue;
import java.util.Random;

public class HeapUsingPriorityQueue{
	PriorityQueue<Integer> p;
	
	public HeapUsingPriorityQueue() {
		p = new PriorityQueue<Integer>();//(10, new IntegerComparator());		
	}
	
	public static void main(String[] args) {
		HeapUsingPriorityQueue h = new HeapUsingPriorityQueue();
		Random r = new Random();
		for(int i=0; i<10; ++i) {
			int t = r.nextInt(100);
			System.out.print(t + " ");
			h.p.add(t);
		}
		System.out.println();
		
		for(int i=0; i<10; ++i) {
			System.out.print(h.p.remove() + " ");
		}
	}
}

