package string;

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
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sbReverse = new StringBuilder(s).reverse();
        while (sb.length() > 0) {
            if (sb.toString().equals(sbReverse.toString())) {
                break;
            }
            sb.deleteCharAt(sb.length() - 1);
            sbReverse.deleteCharAt(0);
        }
        sb = new StringBuilder(s);
        for (int i = 0; i < s.length() - sbReverse.length(); i++) {
            sb.insert(0, s.charAt(s.length() - 1 - i));
        }
        return sb.toString();
    }
}
