package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/validate-binary-search-tree/description/
 * 验证二叉搜索树
 *
 * @Description:
 * @Author linghb
 * @Date: 2024/12/26$ 21:20$
 * @Version 1.0
 */
public class IsValidBST {

	/**
	 * 迭代法
	 *
	 * @param root
	 * @return
	 */
	public static boolean solution1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pre = null;
		if (root != null) {
			stack.add(root);
		}
		while (!stack.isEmpty()) {
			TreeNode curr = stack.peek();
			if (curr != null) {
				stack.pop();
				if (curr.right != null) {
					stack.add(curr.right);
				}
				stack.add(curr);
				stack.add(null);
				if (curr.left != null) {
					stack.add(curr.left);
				}
			} else {
				stack.pop();
				TreeNode temp = stack.pop();
				if (pre != null && pre.val >= temp.val) {
					return false;
				}
				pre = temp;
			}
		}
		return true;
	}


	/**
	 * 递归
	 */
	static TreeNode max;

	public static boolean solution2(TreeNode root) {
		if (root == null) {
			return true;
		}
		// 左
		boolean left = solution2(root.left);
		if (!left) {
			return false;
		}
		// 中
		if (max != null && root.val <= max.val) {
			return false;
		}
		max = root;
		// 右
		boolean right = solution2(root.right);
		return right;
	}


	/**
	 * 迭代
	 *
	 * @param root
	 * @return
	 */
	public static boolean solution3(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left; // 左
			}
			// 中，处理
			TreeNode pop = stack.pop();
			if (pre != null && pop.val <= pre.val) {
				return false;
			}
			pre = pop;

			root = pop.right;// 右
		}
		return true;
	}

	/**
	 * @param root
	 * @return
	 */
	public static boolean solution4(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		traversal(root, result);
		for (int i = 0; i < result.size(); i++) {
			if (i > 0 && result.get(i - 1) >= result.get(i)) {
				return false;
			}
		}
		return true;
	}

	public static void traversal(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		traversal(root.left, result);
		result.add(root.val);
		traversal(root.right, result);
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

		solution4(node5);
	}

}
