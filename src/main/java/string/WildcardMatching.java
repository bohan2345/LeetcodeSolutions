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
     * f(s - 1, p - 1) or f(s - 1, p) or f(s, p - 1), p == *
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
        int slen = s.length();
        int plen = p.length();
        if (plen == 0) {
            return slen == 0;
        }
        int i = 0;
        int j = 0;
        int nxts = -1;
        int nxtp = -1;
        // here only use i as ending condition, for the case j reach the end with no match,
        // it can go back to recorded index and match again
        while (i < slen) {
            if (j < plen && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            } else if (j < plen && p.charAt(j) == '*') {
                // record index i, j; all characters before i, j is matched
                nxtp = j;
                nxts = i;
                // only increase j, skip '*' (try use '*' to match 0 character)
                j++;
            } else {
                if (nxtp == -1) {
                    // don't have '*' in pattern
                    return false;
                } else {
                    nxts++;
                    i = nxts;
                    // only increase i by 1 from previous recorded index, try use '*' to match one more character
                    // which means include s[i] to the match of '*'. (not set i up to the failure point)
                    j = nxtp + 1;
                }
            }
        }
        // if p has character left, only can be true if all the left are *
        while (j < plen && p.charAt(j) == '*') {
            j++;
        }
        return j == plen;
    }
}
