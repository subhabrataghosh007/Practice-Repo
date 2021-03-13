package misc;

/*
 * 
[3,9,20,null,null,15,7]
[1,2,2,3,null,null,3,4,null,null,4]
[1,2,null,3,null,4,null,5]


 * */
public class BalancedBinaryTree {
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

//		TreeNode t = new TreeNode(1);
//		t.left = new TreeNode(2);
//		t.right = new TreeNode(2);
//		t.left.left = new TreeNode(3);
//		t.right.right = new TreeNode(3);
//		t.left.left.left = new TreeNode(4);
//		t.right.right.right = new TreeNode(4);
		
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.left = new TreeNode(3);
		t.left.left.left = new TreeNode(4);
		t.left.left.left.left = new TreeNode(5);
		
		
		BalancedBinaryTree view = new BalancedBinaryTree();

		System.out.println(view.isBalanced1(t));
	}
	
	public boolean isBalanced1(TreeNode root) {
        return isBalancedInternal(root) != -1;
    }

    public int isBalancedInternal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lvalue = isBalancedInternal(root.left);
        int rvalue = isBalancedInternal(root.right);
        if (lvalue == -1 || rvalue == -1) {
            return -1;
        }
        if (Math.abs(lvalue - rvalue) <= 1) {
            return Math.max(lvalue, rvalue) + 1;
        }
        return -1;
    }

}
