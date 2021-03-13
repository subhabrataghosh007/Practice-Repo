package tree;

import java.util.Arrays;
import java.util.List;

public class LowestCommonAncestorBST {

	private Node root;
	
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(20,8,22,4,12,10,14);

		LowestCommonAncestorBST tree = new LowestCommonAncestorBST();
		
		list.forEach(tree::insert);
		
		System.out.println("LCA of (8, 22) :"+tree.LCA(8, 22));
		System.out.println("LCA of (22, 12) :"+tree.LCA( 22, 12));
		System.out.println("LCA of (10, 14) :"+tree.LCA(10, 14));
		System.out.println("LCA of (4, 14) :"+tree.LCA(4, 14));
		System.out.println("LCA of (4, 8) :"+tree.LCA(4, 8));
		
	}

	private int LCA(int n1, int n2) {
		Node n = LCA(root, n1, n2);
		return n.data;
	}
	
	private Node LCA(Node root, int n1, int n2) {
		if (root == null)
			return root;
		
		if (n1 < root.data && n2 < root.data) {
			return LCA(root.left, n1, n2);
		}
		
		if (n1 > root.data && n2 > root.data) {
			return LCA(root.right, n1, n2);
		}
		
		return root;
	}
	
	private void insert(int data) {
		root = insertRecord(root, data);
	}
	
	private Node insertRecord(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}
		
		if (data < root.data) {
			root.left = insertRecord(root.left, data);
		} else if (data > root.data) {
			root.right = insertRecord(root.right, data);
		}
		
		return root;
	}
	
	static class Node  {
		Node left;
		Node right;
		int data;
		
		Node(int data) {
			this.data = data;
		}
	}
}
