package tree;

import tree.LowsestCommonAncestorBT.Node;

public class DistanceTwoNodeInBT {

	public static void main(String[] args) {

		DistanceTwoNodeInBT tree = new DistanceTwoNodeInBT();

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		System.out.println("Distance of (4, 5) :" + tree.Distance(root, 4, 5));
		System.out.println("Distance of (2, 6) :" + tree.Distance(root, 2, 6));
		System.out.println("Distance of (4, 3) :" + tree.Distance(root, 4, 3));
		System.out.println("Distance of (5, 7) :" + tree.Distance(root, 5, 7));
		System.out.println("Distance of (4, 2) :" + tree.Distance(root, 4, 2));
		System.out.println("Distance of (3, 7) :" + tree.Distance(root, 3, 7));
	}

	int Distance(Node root, int n1, int n2) {
		
		Node lca = LCA(root, n1, n2);
		
		int d1 = findLevel(lca, n1, 0);
		int d2 = findLevel(lca, n2, 0);
		
		return d1+d2;
	}
	
	int findLevel(Node root, int n1, int level) {
		
		if (root == null)
			return -1;
		
		if (root.data == n1) 
			return level;
		
		int left = findLevel(root.left, n1, level+1);
		
		if (left == -1)
			return findLevel(root.right, n1, level+1);
		
		return left;
	}
	
	Node LCA(Node root, int n1, int n2) {
		
		if (root == null)
			return root;
		
		if (n1 == root.data || n2 == root.data)
			return root;

		Node left = LCA(root.left, n1, n2);
		Node right = LCA(root.right, n1, n2);
		
		if (null != left && null != right)
			return root;
		
		return left != null ? left : right;
	}
	
	static class Node {
		Node left, right;
		int data;
		
		Node(int data) {
			this.data = data;
		}
	}
}
