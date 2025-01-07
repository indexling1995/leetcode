package tree;

/**
 * 删除二叉搜索树的结点
 *
 * @Description:
 * @Author linghb
 * @Date: 2024/12/30$ 20:50$
 * @Version 1.0
 */
public class DeleteNode {
	public TreeNode solution1(TreeNode root, int key) {
		if (root == null) {
			return root;
		}
		if (root.val == key) {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				TreeNode cur = root.right;
				while (cur.left != null) {
					cur = cur.left;
				}
				cur.left = root.left;
				root = root.right;
				return root;
			}
		}
		if (root.val > key) {
			root.left = solution1(root.left, key);
		}
		if (root.val < key) {
			root.right = solution1(root.right, key);
		}
		return root;
	}
}
