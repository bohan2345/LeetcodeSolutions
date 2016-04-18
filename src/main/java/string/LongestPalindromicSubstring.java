package string;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 * <p>
 * Created by Bohan Zheng on 4/18/2016.
 *
 * @author Bohan Zheng
 */
public class LongestPalindromicSubstring {
    /**
     * reverse and find common substring not working for example: abcdxydcba, abcd is the common substring but not a palindrom
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int[] longestSubStrIndex = {0, 0}; // {start, end}
        for (int i = 0; i < s.length(); ++i) {
            scan(s, i, i, longestSubStrIndex);
            if (i != s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                scan(s, i, i + 1, longestSubStrIndex);
            }
        }
        return s.substring(longestSubStrIndex[0], longestSubStrIndex[1] + 1);
    }

    private void scan(String s, int i, int j, int[] index) {
        int length = index[1] - index[0] + 1;
        int offset = 0;
        for (; i - offset >= 0 && j + offset < s.length(); ++offset) {
            if (s.charAt(i - offset) != s.charAt(j + offset)) {
                break;
            }
        }
        offset--;
        if (j + offset - i + offset + 1 > length) {
            index[0] = i - offset;
            index[1] = j + offset;
        }
    }

    /**
     * Manacher’s algorithm
     */
}
