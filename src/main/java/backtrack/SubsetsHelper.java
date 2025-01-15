package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 * https://leetcode.cn/problems/subsets/description/
 *
 * @Description:
 * @Author linghb
 * @Date: 2025/1/15$ 17:54$
 * @Version 1.0
 */
public class SubsetsHelper {
	static List<List<Integer>> result = new ArrayList<>();
	static LinkedList<Integer> path = new LinkedList<>();

	public static List<List<Integer>> solution(int[] nums) {
		backtracking(nums, 0);
		return result;
	}

	private static void backtracking(int[] nums, int startIndex) {
		result.add(new ArrayList<>(path));
		if (startIndex >= nums.length){
			return;
		}
		for (int i = startIndex; i < nums.length; i++) {
			path.add(nums[i]);
			backtracking(nums, i + 1);
			path.removeLast();
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> result = solution(nums);
		for (List<Integer> path : result) {
			for (Integer item : path) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}


}
