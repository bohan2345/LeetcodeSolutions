package string;

import miscellany.KMPAlgorithm;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 * <p>
 * For example:
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 * <p>
 * Created by Bohan Zheng on 3/14/2016.
 *
 * @author Bohan Zheng
 */
public class ShortestPalindrome {
    /**
     * http://www.jiuzhang.com/solutions/shortest-palindrome/
     */
    public String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
        }
        if (j == s.length()) {
            return s;
        }
        String suffix = s.substring(j);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindrome(s.substring(0, j));
        return prefix + mid + suffix;
    }

    /**
     * solve with KMP
     */
    public String shortestPalindrome2(String s) {
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();
        String ss = s + "&" + reverse + "$";
        int[] next = new KMPAlgorithm().KMPTable(ss.toCharArray());
        String suffix = s.substring(next[next.length - 1]);
        StringBuilder prefix = new StringBuilder(suffix).reverse();
        return prefix.append(s).toString();
    }
}
