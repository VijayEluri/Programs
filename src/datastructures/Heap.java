package datastructures;

/**
 * @author sasik
 * Templated heap datastructure
 */

import java.util.*;

public class Heap<T extends Comparable<T>> {
	ArrayList<T> holder;
	boolean minHeap = true;

	public Heap(final boolean minHeap) {
		this.minHeap = minHeap;
		if(holder == null) {
			holder = new ArrayList<T>();
		}
	}

	public Heap(T element) {
		if (holder == null) {
			holder = new ArrayList<T>();
		}
		insert(element);
	}

	public int size() {
		return holder == null ? 0 : holder.size();
	}

	public void insert(T element) {
		holder.add(element);
		heapify();
	}

	private void heapify() {
		final int size = size();
		if (size < 2) {
			return;
		}
		siftDown(1, size);
	}
	
	private T peek() {
		if(!isEmpty()) {
			return holder.get(0);
		}
		return null;
	}

	private void siftDown(int rootElemId, final int size) {
		if (rootElemId > size) {
			return;
		}
		final int rootIdx = rootElemId - 1;
		T element = holder.get(rootIdx);
		final int leftIdx = rootElemId * 2 - 1, rightIdx = rootElemId * 2;
		int swapIdx = rootIdx;
		T swap = holder.get(swapIdx);
		if (leftIdx < size) {
			siftDown(leftIdx + 1, size);
			if (holder.get(leftIdx).compareTo(swap) < 0) {
				swapIdx = leftIdx;
				swap = holder.get(leftIdx);
			}
			if (rightIdx < size) {
				siftDown(rightIdx + 1, size);
				if (holder.get(rightIdx).compareTo(swap) < 0) {
					swap = holder.get(rightIdx);
					swapIdx = rightIdx;
				}
			}
			if (swapIdx != rootIdx) {
				holder.set(rootIdx, swap);
				holder.set(swapIdx, element);
			}
		} else {
			return;
		}
	}
	
	public T deleteMin() {
		if (!isEmpty()) {
			final int size = size();
			T retElement = holder.get(0);
			holder.set(0, holder.get(size - 1));
			holder.remove(size -1);
			heapify();
			return retElement;
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Size:" + size() + "\t");
		for (int i = 1, n = size(); i <= n; ++i) {
			sb.append(i + ":" + holder.get(i-1));
			sb.append("\t");
		}
		return sb.toString();
	}
	
	public boolean isEmpty() {
		return size() == 0 ? true : false;
	}
	
	public static void main(String[] args) {
		boolean start = false;
		Heap<Integer> heap = null;
		while (!start) {
			Scanner sc = new Scanner(System.in);
			int n = 0;
			while ((n = sc.nextInt()) != -1) {
				if (!start) {
					heap = new Heap<Integer>(n);
					start = true;
				} else {
					heap.insert(n);
				}
				System.out.println(heap.toString());
			}			
		}
		
		while(!heap.isEmpty()) {
			System.out.println(heap.deleteMin());
		}
	}
}
