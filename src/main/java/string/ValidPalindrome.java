package string;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * <p>
 * For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Created by Bohan Zheng on 3/11/16.
 *
 * @author Bohan Zheng
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        if (s.length() == 0)
            return true;
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            while (l < r && !isAlpha(s.charAt(l))) {
                l++;
            }
            while (r > l && !isAlpha(s.charAt(r))) {
                r--;
            }
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    private boolean isAlpha(char c) {
        return (c <= 'z' && c >= 'a') || (c >= '0' && c <= '9');
    }

    public boolean isPalindromeII(String s) {
        s = s.replaceAll("\\W", "");
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString().equalsIgnoreCase(s);
    }
}
