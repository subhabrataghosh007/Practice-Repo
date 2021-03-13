package misc;

import java.util.List;

public class ValidateBinarySearchTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {

		TreeNode t = new TreeNode(10);
		t.left = new TreeNode(5);
		t.right = new TreeNode(15);
		t.right.left = new TreeNode(6);
		t.right.right = new TreeNode(20);

		ValidateBinarySearchTree tree = new ValidateBinarySearchTree();
		System.out.println(tree.isValidBST(t));
	}

	public boolean isValidBST(TreeNode root) {

		if (root == null)
			return true;

		return helper(root, null, null);

	}

	private boolean helper(TreeNode root, Integer max, Integer min) {

		if (null == root)
			return true;
		else if (max != null && root.val >= max || min != null && root.val <= min)
			return false;
		else
			return helper(root.left, root.val, min) && helper(root.right, max, root.val);
		
	}

}
