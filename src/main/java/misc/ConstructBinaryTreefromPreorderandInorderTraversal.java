package misc;

import java.util.HashMap;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	HashMap<Integer, Integer> map = new HashMap<>();
	int preIndex = 0;
	public static void main(String[] args) {
		ConstructBinaryTreefromPreorderandInorderTraversal t = new ConstructBinaryTreefromPreorderandInorderTraversal();

		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };

		t.buildTree(preorder, inorder);

	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		for (int i = 0; i < inorder.length; i++)
			map.put(inorder[i], i);

		TreeNode root = build(preorder, inorder, 0, inorder.length - 1);

		return root;
	}

	private TreeNode build(int[] preorder, int[] inorder, int start, int end) {

		if (start > end)
			return null;
		
		TreeNode root = new TreeNode(preorder[preIndex++]);
		
		if (start == end)
			return root;
		
		int index = map.get(root.val);
		
		root.left = build(preorder, inorder, start, index-1);
		root.right = build(preorder, inorder, index+1, end);
		
		return root;
	}

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

}
