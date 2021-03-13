package tree;

public class LowsestCommonAncestorBT {

	public static void main(String[] args) {

		LowsestCommonAncestorBT tree = new LowsestCommonAncestorBT();

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		System.out.println("LCA of (4, 5) :" + tree.LCA(root, 4, 5).data);
		System.out.println("LCA of (2, 6) :" + tree.LCA(root, 2, 6).data);
		System.out.println("LCA of (4, 3) :" + tree.LCA(root, 4, 3).data);
		System.out.println("LCA of (5, 7) :" + tree.LCA(root, 5, 7).data);
		System.out.println("LCA of (4, 2) :" + tree.LCA(root, 4, 2).data);
		System.out.println("LCA of (3, 7) :" + tree.LCA(root, 3, 7).data);

	}

	Node LCA(Node root, int n1, int n2) {

		if (root == null)
			return root;
		
		if (n1 == root.data || n2 == root.data) {
			return root;
		}
		
		Node leftLCA = LCA(root.left, n1, n2);
		Node rightLCA = LCA(root.right, n1, n2);
		
		if (leftLCA != null&& rightLCA != null)
			return root;
		
		return leftLCA != null ? leftLCA : rightLCA;
	}

	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
		}
	}
}
