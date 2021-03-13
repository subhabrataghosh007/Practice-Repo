package tree;

import java.util.Arrays;
import java.util.List;

public class DistanceTwoNodeInBST {

	public static void main(String[] args) {

		int a = 100_0_00;
		
		DistanceTwoNodeInBST tree = new DistanceTwoNodeInBST();

		List<Integer> list = Arrays.asList(20,8,22,4,12,10,14);
		Node root = null;
		
		for (Integer i : list)
			root = tree.insert(root, i);
		
		//list.forEach(i -> tree.insert(root, i));
		
		System.out.println("Distance of (8, 22) :"+tree.Distance(root, 8, 22));
		System.out.println("Distance of (22, 12) :"+tree.Distance(root, 22, 12));
		System.out.println("Distance of (10, 14) :"+tree.Distance(root, 10, 14));
		System.out.println("Distance of (4, 14) :"+tree.Distance(root, 4, 14));
		System.out.println("Distance of (4, 8) :"+tree.Distance(root, 4, 8));
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
		
		if (n1 < root.data && n2 < root.data)
			return LCA(root.left, n1, n2);
		if (n1 >root.data && n2 > root.data)
			return LCA(root.right, n1, n2);
		
		return root;
	}
	
	Node insert (Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}
		
		if (data < root.data)
			root.left = insert(root.left, data);
		else if (data > root.data)
			root.right = insert(root.right, data);
		
		return root;
	}
	
	static class Node {
		Node left, right;
		int data;
		
		Node(int data) {
			this.data = data;
		}
	}
}
