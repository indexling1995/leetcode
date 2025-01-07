package tree;

/**
 * 二叉树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * @Description:
 * @Author linghb
 * @Date: 2024/12/27$ 16:19$
 * @Version 1.0
 */
public class LowestCommonAncestor {

	public static TreeNode solution1(TreeNode root, TreeNode p, TreeNode q) {
		//递归结束条件
		if (root == null || root == p || root == q) {
			return root;
		}
		// 后序遍历
		TreeNode left = solution1(root.left, p, q);
		TreeNode right = solution1(root.right, p, q);
		// 若未找到节点 p 或 q
		if (left == null && right == null) {
			return null;
		}
		//若找到一个节点
		else if (left == null) {
			return right;
		}
		//若找到一个节点
		else if (right == null) {
			return left;
		}
		//若找到两个节点
		else {
			return root;
		}
	}

}
