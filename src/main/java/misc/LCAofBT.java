package misc;

public class LCAofBT {

	public static void main(String[] args) {

		Node root = new Node(20);
		root.left = new Node(4);
		root.right = new Node(5);
		root.left.left = new Node(8);
		root.left.right = new Node(10);
		root.left.left.left = new Node(100);
		root.left.left.right = new Node(22);
		root.right.left = new Node(25);
		root.right.right = new Node(1);
		
		int n1 = 100;
		int n2 = 1;
		Node n = LCA(root, n1, n2);
		
		System.out.println(n.data);
		
	}
	
	static Node LCA(Node root, int n1, int n2) {
		if (root == null)
			return null;
		
		if (n1 == root.data || n2 == root.data)
			return root;
		
		Node left = LCA(root.left, n1, n2);
		Node right = LCA(root.right, n1, n2);
		
		if (left != null && right != null)
			return root;
		
		if (left != null)
			return left;
		else
			return right;
	}

	
	static class Node {
		Node left, right;
		int data;
		
		Node(int data) {
			this.data = data;
		}
		
	}
}
