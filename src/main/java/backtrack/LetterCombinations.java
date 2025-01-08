package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 *
 * @Description:
 * @Author linghb
 * @Date: 2025/1/8$ 15:24$
 * @Version 1.0
 */
public class LetterCombinations {
	static List<String> result = new ArrayList<>();
	static StringBuilder path = new StringBuilder();

	public static List<String> letterCombinations(String digits) {
		if (digits == null || digits.length() == 0) {
			return result;
		}
		String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		backtracking(digits, numString, 0);
		return result;
	}

	public static void backtracking(String digits, String[] numString, int startIndex) {
		if (startIndex == digits.length()) {
			result.add(path.toString());
			return;
		}
		int digit = digits.toCharArray()[startIndex] - '0';
		String s = numString[digit];
		char[] chars = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			path.append(chars[i]);
			backtracking(digits, numString, startIndex + 1);
			path.deleteCharAt(path.length() - 1);
		}
	}

	public static void main(String[] args) {
		String digits = "23";
		List<String> result = letterCombinations(digits);
		for (String s : result) {
			System.out.println(s);
		}
	}
}
