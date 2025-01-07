package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和3
 * https://leetcode.cn/problems/combination-sum-iii/
 *
 * @Description:
 * @Author linghb
 * @Date: 2025/1/7$ 20:17$
 * @Version 1.0
 */
public class CombinationSum3 {

	static List<List<Integer>> result = new ArrayList<>();
	static LinkedList<Integer> path = new LinkedList<>();

	public static List<List<Integer>> solution1(int k, int n) {
		backtracking1(k, n, 1);
		return result;
	}


	public static void backtracking1(int k, int n, int startIndex) {
		if (path.size() == k) {
			if (n == 0) {
				result.add(new ArrayList<>(path));
			}
			return;
		}

		//i <= 9 - (k - path.size()) + 1 减枝操作
		for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
			path.add(i);
			n = n - i;
			//减枝操作
			if (n < 0) {
				path.removeLast();
				return;
			}
			backtracking1(k, n, i + 1);
			path.removeLast();
			n = n + i;
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> result = solution1(3, 7);
		for (List<Integer> path : result) {
			for (Integer item : path) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}

}
