package tree;

/**
 * 二叉搜索树的插入
 * https://leetcode.cn/problems/insert-into-a-binary-search-tree/description/
 *
 * @Description:
 * @Author linghb
 * @Date: 2024/12/30$ 20:12$
 * @Version 1.0
 */
public class InsertIntoBST {

	/**
	 * 递归
	 *
	 * @param root
	 * @param val
	 * @return
	 */
	public static TreeNode solution1(TreeNode root, int val) {
		// 如果当前节点为空，也就意味着val找到了合适的位置，此时创建节点直接返回。
		if (root == null) {
			return new TreeNode(val);
		}
		// 递归创建右子树
		if (root.val < val) {
			root.right = solution1(root.right, val);
		}
		// 递归创建左子树
		else if (root.val > val) {
			root.left = solution1(root.left, val);
		}
		return root;
	}

	/**
	 * 迭代
	 *
	 * @param root
	 * @param val
	 * @return
	 */
	public static TreeNode solution2(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		TreeNode newRoot = root;
		TreeNode pre = root;
		while (root != null) {
			pre = root;
			if (root.val > val) {
				root = root.left;
			} else if (root.val < val) {
				root = root.right;
			}
		}
		if (pre.val > val) {
			pre.left = new TreeNode(val);
		} else {
			pre.right = new TreeNode(val);
		}

		return newRoot;
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

		solution2(node5, 6);
	}

}
