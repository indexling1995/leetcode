package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将有序数组转换为二叉搜索树
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * @Description:
 * @Author linghb
 * @Date: 2025/1/7$ 20:56$
 * @Version 1.0
 */
public class SortedArrayToBST {

	/**
	 * 递归：左闭右开 [left,right)
	 *
	 * @param nums
	 * @return
	 */
	public static TreeNode solution1(int[] nums) {
		return traversal1(nums, 0, nums.length);
	}

	public static TreeNode traversal1(int[] nums, int left, int right) {
		if (left >= right) {
			return null;
		}
		if (right - left == 1) {
			return new TreeNode(nums[left]);
		}
		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = traversal1(nums, left, mid);
		root.right = traversal1(nums, mid + 1, right);
		return root;
	}


	/**
	 * 递归：左闭右闭 [left,right]
	 *
	 * @param nums
	 * @return
	 */
	public static TreeNode solution2(int[] nums) {
		return traversal2(nums, 0, nums.length - 1);
	}

	public static TreeNode traversal2(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = traversal2(nums, left, mid - 1);
		root.right = traversal2(nums, mid + 1, right);
		return root;
	}

	/**
	 * 迭代: 左闭右闭 [left,right]
	 * @param nums
	 * @return
	 */
	public static TreeNode solution3(int[] nums) {
		if (nums.length == 0) {
			return null;
		}

		//根节点初始化
		TreeNode root = new TreeNode(-1);
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		Queue<Integer> leftQueue = new LinkedList<>();
		Queue<Integer> rightQueue = new LinkedList<>();

		// 根节点入队列
		nodeQueue.offer(root);
		// 0为左区间下标初始位置
		leftQueue.offer(0);
		// nums.size() - 1为右区间下标初始位置
		rightQueue.offer(nums.length - 1);

		while (!nodeQueue.isEmpty()) {
			TreeNode currNode = nodeQueue.poll();
			int left = leftQueue.poll();
			int right = rightQueue.poll();
			int mid = left + ((right - left) >> 1);

			// 将mid对应的元素给中间节点
			currNode.val = nums[mid];

			// 处理左区间
			if (left <= mid - 1) {
				currNode.left = new TreeNode(-1);
				nodeQueue.offer(currNode.left);
				leftQueue.offer(left);
				rightQueue.offer(mid - 1);
			}

			// 处理右区间
			if (right >= mid + 1) {
				currNode.right = new TreeNode(-1);
				nodeQueue.offer(currNode.right);
				leftQueue.offer(mid + 1);
				rightQueue.offer(right);
			}
		}
		return root;
	}


	public static void main(String[] args) {
		int[] nums = {-10, -3, 0, 5, 9};
		TreeNode root = solution3(nums);
		System.out.println(root.val);
	}

}
