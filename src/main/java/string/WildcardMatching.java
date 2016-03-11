package string;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aa", "*") → true
 * isMatch("aa", "a?") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * <p>
 * Created by Bohan Zheng on 3/10/2016.
 *
 * @author Bohan Zheng
 */
public class WildcardMatching {
    /**
     * f(s,p) = f(s - 1, p - 1), p == s or p == ?
     *          f(s - 1, p - 1) or f(s - 1, p) or f(s, p - 1), p == *
     */
    public boolean isMatch(String s, String p) {
        boolean[][] table = new boolean[s.length() + 1][p.length() + 1];
        table[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            table[0][i] = table[0][i - 1] && p.charAt(i - 1) == '*';
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    table[i][j] = table[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    table[i][j] = table[i - 1][j - 1] || table[i - 1][j] || table[i][j - 1];
                } else {
                    table[i][j] = false;
                }
            }
        }
        return table[s.length()][p.length()];
    }

    public boolean isMatchII(String s, String p) {
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {

        }
        return i == s.length() && j == p.length();
    }
}
