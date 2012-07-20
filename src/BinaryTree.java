public class BinaryTree {
	private class Node {
		int data;
		Node left;
		Node right;
	}
	
	public Node root;	
	int maxPathValue(final Node present, final StringBuffer sb) {
		if(present == null) {
			return 0;
		}
		final StringBuffer left = new StringBuffer(), right = new StringBuffer();
		int leftMaxPath = maxPathValue(present.left, left);
		int rightMaxPath = maxPathValue(present.right, right);
//		return (int)Math.max(leftMaxPath, rightMaxPath) + present.data;
		if(leftMaxPath > rightMaxPath) {
			sb.append(left);
			sb.append(" ");
			sb.append(present.data);
			return leftMaxPath;
		} else {
			sb.append(right);
			sb.append(" ");
			sb.append(present.data);
			return rightMaxPath;
		}
		
	}
}
