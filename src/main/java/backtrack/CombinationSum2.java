package backtrack;

import java.util.*;

/**
 * 组合总和2
 * https://leetcode.cn/problems/combination-sum-ii/
 *
 * @Description:
 * @Author linghb
 * @Date: 2025/1/8$ 17:14$
 * @Version 1.0
 */
public class CombinationSum2 {

	static List<List<Integer>> result = new ArrayList<>();
	static List<Integer> path = new ArrayList<>();
	static boolean[] used;

	public static List<List<Integer>> solution(int[] candidates, int target) {
		used = new boolean[candidates.length];
		backtracking(candidates, target, 0);
		return result;
	}

	public static void backtracking(int[] candidates, int target, int startIndex) {
		if (target == 0) {
			result.add(new ArrayList<>(path));
			return;
		}

		for (int i = startIndex; i < candidates.length; i++) {
			if (target - candidates[i] < 0) {
				break;
			}
			if (i > 0 && candidates[i - 1] == candidates[i] && !used[i - 1]) {
				continue;
			}
			used[i] = true;
			target -= candidates[i];
			path.add(candidates[i]);
			backtracking(candidates, target, i + 1);
			target += candidates[i];
			used[i] = false;
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] candidates = {10, 1, 2, 7, 6, 1, 5};
		Arrays.sort(candidates);
		int target = 8;
		List<List<Integer>> result = solution(candidates, target);
		for (List<Integer> path : result) {
			for (Integer item : path) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}

}
