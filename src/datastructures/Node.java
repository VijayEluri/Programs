package datastructures;


public class Node implements Comparable<Node> {
	public int id;
	public String name;
	
	public Node(int id) {
		this.id = id;
	}
	
	@Override
	public int compareTo(Node arg0) {
		return this.id - arg0.id;
	}
	
	@Override
	public int hashCode() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return "Node:" + id;
	}
}
