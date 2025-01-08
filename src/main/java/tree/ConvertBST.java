package tree;

import java.util.Stack;

/**
 * 把二叉搜索树转换为累加树
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/
 *
 * @Description:
 * @Author linghb
 * @Date: 2025/1/8$ 10:25$
 * @Version 1.0
 */
public class ConvertBST {
	static int sum;

	public static TreeNode solution1(TreeNode root) {
		sum = 0;
		traverse1(root);
		return root;
	}

	public static void traverse1(TreeNode cur) {
		if (cur == null) {
			return;
		}
		traverse1(cur.right);
		sum += cur.val;
		cur.val = sum;
		traverse1(cur.left);
	}


	public static TreeNode solution2(TreeNode root) {
		int pre = 0;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || stack.size() > 0) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.right;
			} else {
				cur = stack.pop();
				cur.val += pre;
				pre = cur.val;
				cur = cur.left;
			}
		}
		return root;
	}


	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(0);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(1);

		node1.left = node2;
		node1.right = node3;

		node2.right = node4;

		node4.left = node5;

		TreeNode root = solution2(node1);
		System.out.println(root.val);
	}

}
