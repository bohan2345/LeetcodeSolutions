package string;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * <p>
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * <p>
 * Created by Bohan Zheng on 5/24/2016.
 *
 * @author Bohan Zheng
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        Stack<Integer> S = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!S.isEmpty() && s.charAt(i) == ')' && s.charAt(S.peek()) == '(') {
                S.pop();
                if (S.isEmpty()) max = i + 1;
                else max = Math.max(i - S.peek(), max);
            } else S.push(i);
        }
        return max;
    }

    public int longestValidParenthesesII(String s) {
        int max = 0, start = 0;
        Stack<Integer> stack = new Stack<>();
        int[] a = new int[s.length()];
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') stack.push(i);
            else if (!stack.empty()) {
                start = stack.pop();
                a[i] = i - start + 1;
                if (start > 1) a[i] += a[start - 1];
                max = Math.max(max, a[i]);
            }
        }
        return max;
    }
}
