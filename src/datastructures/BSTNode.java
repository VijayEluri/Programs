package datastructures;

/**
 * 
 * @author sasik
 * You are given a complete tree, with left and right pointers 
 * set as usual but there are another two pointer in the "node"
 * named "left_sibling" and "right_sibling". 
 * Write a function to set the sibling pointers to their respective values. 
 * @param <T>
 */

public class BSTNode<T extends Comparable<T>> {
	public T element;
	public BSTNode<T> leftChild, rightChild, leftSibling, rightSibling;
	public BSTNode (T element, BSTNode<T> left, BSTNode<T> right) {
		this.element = element;
		this.leftChild = left;
		this.rightChild = right;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Element: " + element.toString());
		sb.append("\t LeftChild: " + (leftChild == null ? "NULL" : leftChild.element.toString()));
		sb.append("\t RightChild: " + (rightChild == null ? "NULL" : rightChild.element.toString()));
		sb.append("\t LeftSibling: " + (leftSibling == null ? "NULL" : leftSibling.element.toString()));
		sb.append("\t RightSibling: " + (rightSibling == null ? "NULL" : rightSibling.element.toString()));
		return sb.toString();
	}
}
