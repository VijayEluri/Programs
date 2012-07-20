package datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BinarySearchTree<T extends Comparable<T>> {
	BSTNode<T> root;
	int numElements = 0;

	public BinarySearchTree(T element) {
		root = new BSTNode<T>(element, null, null);
		numElements = 1;
	}
	
	public BinarySearchTree(){ 
		root = null;
		numElements = 0;
	}

	public void insert(T element) {
		if(root == null) {
			root = new BSTNode<T>(element, null, null);
			return;
		}
		
		BSTNode<T> temp = root, tempParent = null;
		boolean isItLeft = true;
		while (temp != null) {
			tempParent = temp;
			if (temp.element.compareTo(element) <= 0) {
				temp = temp.rightChild;
				isItLeft = false;
			} else {
				temp = temp.leftChild;
				isItLeft = true;
			}
		}
		temp = new BSTNode<T>(element, null, null);
		if (isItLeft) {
			tempParent.leftChild = temp;
		} else {
			tempParent.rightChild = temp;
		}
	}

	public void inOrder() {
		inOrder(this.root);
	}

	public void inOrder(BSTNode<T> node) {
		if (node == null) {
			return;
		}
		inOrder(node.leftChild);
		System.out.println(node.toString());
		inOrder(node.rightChild);
	}

	public void preOrder() {
		preOrder(this.root);
	}

	public void preOrder(BSTNode<T> node) {
		if (node == null) {
			return;
		}
		System.out.println(node.toString());
		preOrder(node.leftChild);
		preOrder(node.rightChild);
	}

	public void addSiblingPointers(BSTNode<T> root) {
		LinkedList<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
		queue.add(root);
		BSTNode<T> dummy = new BSTNode<T>(null, null, null);
		queue.add(dummy);
		ArrayList<BSTNode<T>> inorderSiblings = new ArrayList<BSTNode<T>>();
		boolean isDummy = false;
		while (!queue.isEmpty()) {
			final BSTNode<T> node = queue.removeFirst();
			if (node == dummy) {
				if (isDummy) {
					break;
				}
				isDummy = true;
				if (inorderSiblings.size() > 1) {
					setSiblings(inorderSiblings);
				}
				inorderSiblings.clear();
				queue.add(dummy);
			} else {
				inorderSiblings.add(node);
				isDummy = false;
				if (node.leftChild != null) {
					queue.add(node.leftChild);
				}
				if (node.rightChild != null) {
					queue.add(node.rightChild);
				}
			}
		}
	}

	private void setSiblings(ArrayList<BSTNode<T>> listOfSiblingsInOrder) {
		final int numNodes = listOfSiblingsInOrder.size();
		BSTNode<T> left = null, present = null, right = null;
		for (int i = 0; i < numNodes - 1; ++i) {
			present = listOfSiblingsInOrder.get(i);
			right = listOfSiblingsInOrder.get(i + 1);
			present.leftSibling = left;
			present.rightSibling = right;

			// Update
			left = present;
		}
		listOfSiblingsInOrder.get(numNodes - 1).rightSibling = null;
	}

	public static void main(String[] args) {
		boolean start = false;
		BinarySearchTree<Integer> bst = null;
		while (!start) {
			Scanner sc = new Scanner(System.in);
			int n = 0;
			while ((n = sc.nextInt()) != -1) {
				if (!start) {
					bst = new BinarySearchTree<Integer>(n);
					start = true;
				} else {
					bst.insert(n);
				}
			}
		}
		bst.preOrder();
		bst.addSiblingPointers(bst.root);
		System.out.println("After adding siblings");
		bst.preOrder();
	}
}
