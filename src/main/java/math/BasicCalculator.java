package math;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * <p>
 * Created by Bohan Zheng on 4/26/2016.
 *
 * @author Bohan Zheng
 */
public class BasicCalculator {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if ('0' <= c && c <= '9') {
                int tmp = i;
                i = getNum(s, i);
                stack.push(s.substring(tmp, i + 1));
            } else if (c == ')') {
                int tmpSum = calculate(stack);
                stack.push(String.valueOf(tmpSum));
            } else {
                stack.push(Character.toString(c));
            }
        }
        return calculate(stack);
    }

    private int getNum(String s, int i) {
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!('0' <= c && c <= '9')) {
                break;
            }
        }
        return i - 1;
    }

    private int calculate(Stack<String> stack) {
        int tmpSum = 0;
        while (!stack.isEmpty()) {
            String tmpStr = stack.pop();
            if (tmpStr.equals("(")) {
                break;
            }
            try {
                int n = Integer.valueOf(tmpStr);
                int symbol = 1;
                if (!stack.isEmpty() && stack.peek().equals("-")) {
                    symbol = -1;
                }
                tmpSum += n * symbol;
            } catch (NumberFormatException e) {
                continue;
            }
        }
        return tmpSum;
    }

    public int calculate2(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                int j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    num = 10 * num + (s.charAt(j) - '0');
                    j++;
                }
                res += stack.pop() * num;
                i = j - 1;
            } else if (c == '+' || c == '(') {
                stack.push(stack.peek());
            } else if (c == '-') {
                stack.push(-1 * stack.peek());
            } else if (c == ')') {
                stack.pop();
            }
        }
        return res;
    }
}
