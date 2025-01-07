package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二叉搜索树中的众数
 * https://leetcode.cn/problems/find-mode-in-binary-search-tree/description/
 *
 * @Description:
 * @Author linghb
 * @Date: 2024/12/27$ 11:27$
 * @Version 1.0
 */
public class FindMode {

	/**
	 * 暴力法
	 * @param root
	 * @return
	 */
	public static int[] solution1(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		Map<Integer, Integer> map = new HashMap<>();
		// 获得频率 Map
		searchBST(root, map);
		List<Integer> result = new ArrayList<>();
		int count = Integer.MIN_VALUE;
		for (Map.Entry<Integer, Integer> item : map.entrySet()) {
			if (item.getValue() > count) {
				result.clear();
				result.add(item.getKey());
				count = item.getValue();
			} else if (item.getValue() == count) {
				result.add(item.getKey());
			}
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}


	static void searchBST(TreeNode curr, Map<Integer, Integer> map) {
		if (curr == null) {
			return;
		}
		map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
		searchBST(curr.left, map);
		searchBST(curr.right, map);
	}


	/**
	 * 迭代法
	 * @param root
	 * @return
	 */
	static ArrayList<Integer> resList;
	static int maxCount;
	static int count;
	static TreeNode pre;
	public static int[] solution2(TreeNode root) {
		resList = new ArrayList<>();
		maxCount = 0;
		count = 0;
		pre = null;
		findMode(root);
		int[] res = new int[resList.size()];
		for (int i = 0; i < resList.size(); i++) {
			res[i] = resList.get(i);
		}
		return res;
	}


	public static void findMode(TreeNode root) {
		if (root == null) {
			return;
		}
		findMode(root.left);

		int rootValue = root.val;
		// 计数
		if (pre == null || rootValue != pre.val) {
			count = 1;
		} else {
			count++;
		}
		// 更新结果以及maxCount
		if (count > maxCount) {
			resList.clear();
			resList.add(rootValue);
			maxCount = count;
		} else if (count == maxCount) {
			resList.add(rootValue);
		}
		pre = root;

		findMode(root.right);
	}


	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(2);

		node1.right = node2;
		node2.left = node3;

		solution2(node1);
	}

}
