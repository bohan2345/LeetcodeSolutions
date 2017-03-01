package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * <p>
 * Created by Bohan Zheng on 2/21/16.
 *
 * @author Bohan Zheng
 */
public class ValidParentheses {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    Map<Character, Character> map = new HashMap<>(3);
    map.put(')', '(');
    map.put(']', '[');
    map.put('}', '{');
    for (int i = 0; i < s.length(); i++) {
      char p = s.charAt(i);
      if (stack.isEmpty() || !map.containsKey(p)) {
        stack.push(p);
        continue;
      }
      if (map.get(p) == stack.peek()) {
        stack.pop();
      } else {
        return false;
      }
    }
    return stack.isEmpty();
  }
}
