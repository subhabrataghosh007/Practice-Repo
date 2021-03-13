package misc;

import java.util.*;

class BinaryTreeRightSideView {
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
		
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.right = new TreeNode(3);
		t.left.right = new TreeNode(5);
		//t.left.right.right = new TreeNode(6);
		t.right.left = new TreeNode(30);
		//t.right.right = new TreeNode(4);
		
		
		BinaryTreeRightSideView view = new BinaryTreeRightSideView();
		List<Integer> result = view.rightSideView(t);
		
		System.out.println(result);
	}

	int nextLevel = 0;
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        dfs(root, result, 0);
        
        return result;
    }

	private void dfs(TreeNode root, List<Integer> result, int currentLevel) {
        
		if (root == null)
			return ;
		
		if (currentLevel >= nextLevel) {
			result.add(root.val);
			nextLevel++;
		}
		
		dfs(root.right, result, currentLevel+1);
		dfs(root.left, result, currentLevel+1);
    }
}