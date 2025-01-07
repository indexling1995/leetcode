package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 * https://leetcode.cn/problems/combinations/
 *
 * @Description:
 * @Author linghb
 * @Date: 2025/1/7$ 15:59$
 * @Version 1.0
 */
public class Combine {
	static List<List<Integer>> result = new ArrayList<>();
	static LinkedList<Integer> path = new LinkedList<>();

	public static List<List<Integer>> solution1(int n, int k) {
		backtracking1(n, k, 1);
		return result;
	}

	public static void backtracking1(int n, int k, int startIndex) {
		if (path.size() == k) {
			result.add(new ArrayList<>(path));
			return;
		}
		for (int i = startIndex; i <= n; i++) {
			path.add(i);
			backtracking1(n, k, i + 1);
			path.removeLast();
		}
	}

	/**
	 * 减枝优化
	 *
	 * @param n
	 * @param k
	 * @param startIndex
	 */
	public static void backtracking2(int n, int k, int startIndex) {
		if (path.size() == k) {
			result.add(new ArrayList<>(path));
			return;
		}
		for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
			path.add(i);
			backtracking2(n, k, i + 1);
			path.removeLast();
		}
	}


	public static void main(String[] args) {
		List<List<Integer>> result = solution1(4, 2);
		for (List<Integer> path : result) {
			for (Integer item : path) {
				System.out.print(item + " ");
			}
			System.out.println("end");
		}
	}

}
