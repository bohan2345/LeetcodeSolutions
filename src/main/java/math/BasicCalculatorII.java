package math;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * <p>
 * Created by Bohan Zheng on 4/26/2016.
 *
 * @author Bohan Zheng
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int tmp = i;
                i = getNum(s, i);
                stack.push(s.substring(tmp, i + 1).trim());
            } else if (c == '+' || c == '-') {
                stack.push(Character.toString(c));
            } else if (c == '*' || c == '/') {
                int tmp = i + 1;
                i = getNum(s, i + 1);
                int b = Integer.valueOf(s.substring(tmp, i + 1).trim());
                int a = Integer.valueOf(stack.pop());
                int n = c == '*' ? a * b : a / b;
                stack.push(String.valueOf(n));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            String tmpStr = stack.pop();
            int a = Integer.valueOf(tmpStr);
            if (stack.isEmpty() || stack.pop().equals("+")) {
                sum += a;
            } else {
                sum -= a;
            }
        }
        return sum;
    }

    private int getNum(String s, int i) {
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (!Character.isDigit(c)) {
                break;
            }
        }
        return i - 1;
    }
}
