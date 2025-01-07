package tree;

/**
 * 修建二叉树
 * https://leetcode.cn/problems/trim-a-binary-search-tree/
 *
 * @Description:
 * @Author linghb
 * @Date: 2025/1/3$ 18:14$
 * @Version 1.0
 */
public class TrimBST {
	/**
	 * 递归
	 *
	 * @param root
	 * @param low
	 * @param high
	 * @return
	 */
	public static TreeNode solution1(TreeNode root, int low, int high) {
		if (root == null) {
			return null;
		}
		if (root.val < low) {
			return solution1(root.right, low, high);
		}
		if (root.val > high) {
			return solution1(root.left, low, high);
		}
		// root在[low,high]范围内
		root.left = solution1(root.left, low, high);
		root.right = solution1(root.right, low, high);
		return root;
	}

	public static TreeNode solution2(TreeNode root, int low, int high) {
		if(root == null) {
			return null;
		}
		// 处理头结点，让root移动到[L, R] 范围内，注意是左闭右闭
		while(root != null && (root.val < low || root.val > high)){
			if(root.val < low) {
				root = root.right;
			} else {
				root = root.left;
			}
		}

		TreeNode curr = root;

		//此时root已经在[L, R] 范围内，处理左孩子元素小于L的情况
		while(curr != null){
			while(curr.left != null && curr.left.val < low){
				curr.left = curr.left.right;
			}
			curr = curr.left;
		}

		curr = root;

		//此时root已经在[L, R] 范围内，处理右孩子大于R的情况
		while(curr != null){
			while(curr.right != null && curr.right.val > high){
				curr.right = curr.right.left;
			}
			curr = curr.right;
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

		TreeNode root = solution1(node1, 1, 3);
		System.out.println(root.val);
	}

}
