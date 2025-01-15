package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 集合2
 * https://leetcode.cn/problems/subsets-ii/description/
 * @Description:
 * @Author linghb
 * @Date: 2025/1/15$ 19:32$
 * @Version 1.0
 */
public class SubsetsWithDup {
	static List<List<Integer>> result = new ArrayList<>();
	static LinkedList<Integer> path = new LinkedList<>();
	static boolean[] used;

	public static List<List<Integer>> solution(int[] nums) {
		used = new boolean[nums.length];
		backtracking(nums, 0, used);
		return result;
	}

	private static void backtracking(int[] nums, int startIndex, boolean[] used) {
		result.add(new ArrayList<>(path));
		if (startIndex >= nums.length) {
			return;
		}
		for (int i = startIndex; i < nums.length; i++) {
			if (i > 1 && nums[i] == nums[i - 1] && !used[i - 1]) {
				return;
			}
			used[i] = true;
			path.add(nums[i]);
			backtracking(nums, i + 1, used);
			path.removeLast();
			used[i] = false;
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 2};
		List<List<Integer>> result = solution(nums);
		for (List<Integer> path : result) {
			for (Integer item : path) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}
}
