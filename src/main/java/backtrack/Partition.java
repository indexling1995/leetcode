package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文字串
 * https://leetcode.cn/problems/palindrome-partitioning/
 *
 * @Description:
 * @Author linghb
 * @Date: 2025/1/8$ 18:26$
 * @Version 1.0
 */
public class Partition {
	static List<List<String>> result = new ArrayList<>();
	static List<String> path = new ArrayList<>();

	public static List<List<String>> solution(String s) {
		backtracking(s, 0, new StringBuilder());
		return result;
	}

	public static void backtracking(String s, int startIndex, StringBuilder sb) {
		if (startIndex >= s.length()) {
			result.add(new ArrayList<>(path));
			return;
		}
		for (int i = startIndex; i < s.length(); i++) {
			sb.append(s.charAt(i));
			if (isPalindrome(sb.toString())) {
				path.add(sb.toString());
				backtracking(s, i + 1, new StringBuilder());
				path.remove(path.size() - 1);
			}
		}
	}

	public static boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i <= j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "aab";
		List<List<String>> result = solution(s);
		for (List<String> path : result) {
			for (String item : path) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}


}
