package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 * https://leetcode.cn/problems/combination-sum/
 *
 * @Description:
 * @Author linghb
 * @Date: 2025/1/8$ 16:15$
 * @Version 1.0
 */
public class CombinationSum {

	static List<List<Integer>> result = new ArrayList<>();
	static List<Integer> path = new ArrayList<>();

	public static List<List<Integer>> solution(int[] candidates, int target) {
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
			target -= candidates[i];
			path.add(candidates[i]);
			backtracking(candidates, target, i);
			target += candidates[i];
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] candidates = {2, 3, 6, 7};
		int target = 7;
		List<List<Integer>> result = solution(candidates, target);
		for (List<Integer> path : result) {
			for (Integer item : path) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}
}



