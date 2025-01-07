package tree;

import java.util.Stack;

/**
 * 搜索树的最小绝对差
 * https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/
 *
 * @Description:
 * @Author linghb
 * @Date: 2024/12/27$ 10:32$
 * @Version 1.0
 */
public class GetMinimumDifference {

	/**
	 * 记录上一个遍历的结点
	 */
	static TreeNode pre;
	static int result = Integer.MAX_VALUE;

	/**
	 * 递归
	 *
	 * @param root
	 * @return
	 */
	public static int solution1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		traversal(root);
		return result;
	}

	public static void traversal(TreeNode root) {
		if (root == null) {
			return;
		}
		//左
		traversal(root.left);
		//中
		if (pre != null) {
			result = Math.min(result, root.val - pre.val);
		}
		pre = root;
		//右
		traversal(root.right);
	}


	/**
	 * 迭代法
	 *
	 * @param root
	 * @return
	 */
	public static int solution2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		TreeNode pre = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		int result = Integer.MAX_VALUE;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				if (pre != null) {
					result = Math.min(result, cur.val - pre.val);
				}
				pre = cur;
				cur = cur.right;
			}
		}
		return result;
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

		solution2(node5);
	}

}
