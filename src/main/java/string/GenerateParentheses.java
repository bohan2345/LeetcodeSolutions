package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * <p>
 * Created by Bohan Zheng on 4/26/2016.
 *
 * @author Bohan Zheng
 */
public class GenerateParentheses {
  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    generate(res, n, n, new StringBuilder());
    return res;
  }

  private void generate(List<String> res, int left, int right, StringBuilder tmpSB) {
    if (left == 0 && right == 0) {
      res.add(tmpSB.toString());
      return;
    }
    if (left > 0) {
      tmpSB.append('(');
      generate(res, left - 1, right, tmpSB);
      tmpSB.deleteCharAt(tmpSB.length() - 1);
    }
    if (right > left) {
      tmpSB.append(')');
      generate(res, left, right - 1, tmpSB);
      tmpSB.deleteCharAt(tmpSB.length() - 1);
    }
  }
}
