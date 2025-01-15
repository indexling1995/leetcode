package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原ip地址
 * https://leetcode.cn/problems/restore-ip-addresses/
 *
 * @Description:
 * @Author linghb
 * @Date: 2025/1/15$ 15:00$
 * @Version 1.0
 */
public class RestoreIpAddresses {

	static List<String> result = new ArrayList<>();

	public static List<String> solution1(String s) {
		StringBuilder sb = new StringBuilder(s);
		backTracking(sb, 0, 0);
		return result;
	}

	private static void backTracking(StringBuilder s, int startIndex, int dotCount) {
		if (dotCount == 3) {
			if (isValid(s, startIndex, s.length() - 1)) {
				result.add(s.toString());
			}
			return;
		}
		for (int i = startIndex; i < s.length(); i++) {
			if (isValid(s, startIndex, i)) {
				s.insert(i + 1, '.');
				backTracking(s, i + 2, dotCount + 1);
				s.deleteCharAt(i + 1);
			} else {
				break;
			}
		}
	}

	private static boolean isValid(StringBuilder s, int start, int end) {
		if (start > end) {
			return false;
		}
		if (s.charAt(start) == '0' && start != end) {
			return false;
		}
		int num = 0;
		for (int i = start; i <= end; i++) {
			int digit = s.charAt(i) - '0';
			num = num * 10 + digit;
			if (num > 255) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "25525511135";
		List<String> result = solution1(s);
		for (String res : result) {
			System.out.println(res);
		}
	}

}
