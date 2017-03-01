package string;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * <p>
 * Created by Bohan Zheng on 5/23/2016.
 *
 * @author Bohan Zheng
 */
public class RegularExpressionMatching {
  public boolean isMatch(String s, String p) {
    boolean[][] table = new boolean[p.length() + 1][s.length() + 1];
    table[0][0] = true;
    for (int i = 0; i < p.length(); i++) {
      if (p.charAt(i) == '*') {
        table[i + 1][0] = table[i][0];
      } else if (i + 1 < p.length() && p.charAt(i + 1) == '*') {
        table[i + 1][0] = table[i][0];
      }
    }
    for (int i = 0; i < p.length(); i++) {
      for (int j = 0; j < s.length(); j++) {
        char pc = p.charAt(i), sc = s.charAt(j);
        if (pc == '*') {
          // f(i, j) = f(i - 1. j)
          table[i + 1][j + 1] = table[i][j + 1];
        } else if (i + 1 < p.length() && p.charAt(i + 1) == '*') {
          // f(i, j) = f(i, j - 1) && (p[i] == s[j] || p[i] == .) , try to match with p[i]
          //         = f(i - 1, j)                                  skip p[i]
          table[i + 1][j + 1] = (table[i + 1][j] && (pc == '.' || pc == sc)) || table[i][j + 1];
        } else {
          // f(i, j) = f(i - 1, j - 1) && (p[i] == s[j] || p[i] == .)
          table[i + 1][j + 1] = table[i][j] && (pc == '.' || pc == sc);
        }
      }
    }
    return table[p.length()][s.length()];
  }
}
