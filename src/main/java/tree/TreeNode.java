package tree;

/**
 * @Description:
 * @Author linghb
 * @Date: 2024/12/24$ 20:27$
 * @Version 1.0
 */
public class TreeNode {
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
