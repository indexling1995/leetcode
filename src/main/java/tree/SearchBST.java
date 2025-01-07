package tree;

import java.util.Stack;

/**
 * 二叉搜索树中的搜索
 * https://leetcode.cn/problems/search-in-a-binary-search-tree/description/
 * @Description:
 * @Author linghb
 * @Date: 2024/12/26$ 20:34$
 * @Version 1.0
 */
public class SearchBST {
	/**
	 * 递归法
	 *
	 * @param root
	 * @param val
	 * @return
	 */
	public static TreeNode solution1(TreeNode root, int val) {
		if (root == null || root.val == val) {
			return root;
		}
		TreeNode result = null;
		if (root.val < val) {
			result = solution1(root.right, val);
		}
		if (root.val > val) {
			result = solution1(root.left, val);
		}
		return result;
	}

	/**
	 * 迭代法
	 *
	 * @param root
	 * @param val
	 * @return
	 */
	public static TreeNode solution2(TreeNode root, int val) {
		if (root == null || root.val == val) {
			return root;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode pop = stack.pop();
			if (pop.val == val) {
				return pop;
			}
			if (pop.right != null) {
				stack.push(pop.right);
			}
			if (pop.left != null) {
				stack.push(pop.left);
			}
		}
		return null;
	}

	public static TreeNode solution3(TreeNode root, int val) {
		while (root != null) {
			if (val < root.val) {
				root = root.left;
			} else if (val > root.val) {
				root = root.right;
			} else {
				return root;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		TreeNode root2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(5);

		node5.left = root2;
		node5.right = node6;
		root2.left = node4;
		node6.right = node7;

		solution3(node5, 1);
	}


}
