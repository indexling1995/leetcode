package tree;

import java.util.Stack;

/**
 * 合并两个二叉树
 * https://leetcode.cn/problems/merge-two-binary-trees/description/
 * @Description:
 * @Author linghb
 * @Date: 2024/12/24$ 20:41$
 * @Version 1.0
 */
public class MergeTrees {
	/**
	 * 递归
	 *
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static TreeNode solution1(TreeNode root1, TreeNode root2) {
		if (root1 == null) {
			return root2;
		}
		if (root2 == null) {
			return root1;
		}
		root1.val += root2.val;
		root1.left = solution1(root1.left, root2.left);
		root1.right = solution1(root1.right, root2.right);
		return root1;
	}

	/**
	 * 使用栈迭代
	 *
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static TreeNode solution2(TreeNode root1, TreeNode root2) {
		if (root1 == null) {
			return root2;
		}
		if (root2 == null) {
			return root1;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root2);
		stack.push(root1);
		while (!stack.isEmpty()) {
			TreeNode node1 = stack.pop();
			TreeNode node2 = stack.pop();
			node1.val += node2.val;
			if (node2.right != null && node1.right != null) {
				stack.push(node2.right);
				stack.push(node1.right);
			} else {
				if (node1.right == null) {
					node1.right = node2.right;
				}
			}
			if (node2.left != null && node1.left != null) {
				stack.push(node2.left);
				stack.push(node1.left);
			} else {
				if (node1.left == null) {
					node1.left = node2.left;
				}
			}
		}
		return root1;
	}


	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(5);
		root1.left = node2;
		root1.right = node1;
		node2.left = node3;


		TreeNode root2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(5);

		root2.left = node4;
		root2.right = node5;
		node4.right = node6;
		node5.right = node7;

		//solution1(root1,root2);
		solution2(root1, root2);
	}

}
