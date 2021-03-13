package misc;

class ConvertSortedArraytoBinarySearchTree {

	public static void main(String[] args) {
		int[] nums = { -10, -3, 0, 5, 9 };
		
		ConvertSortedArraytoBinarySearchTree tree = new ConvertSortedArraytoBinarySearchTree();
		
		tree.sortedArrayToBST(nums);
		
		System.out.println("...");
		
	}

	public TreeNode sortedArrayToBST(int[] nums) {

		TreeNode root = constructBST(nums, 0, nums.length-1);
		
		return root;
	}

	private TreeNode constructBST(int[] nums, int l, int r) {
		if (l > r)
			return null;

		int mid = l + (r - l) / 2;

		TreeNode root = new TreeNode(nums[mid]);
		root.left = constructBST(nums, l, mid - 1);
		root.right = constructBST(nums, mid + 1, r);
		
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

		@Override
		public String toString() {
			return "TreeNode [val=" + val + "]";
		}
		
	}
}