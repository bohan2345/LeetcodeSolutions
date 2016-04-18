package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Created by Bohan Zheng on 4/18/2016.
 *
 * @author Bohan Zheng
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, leng = 0;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (set.contains(c)) {
                maxLength = Math.max(maxLength, leng);
                set.remove(s.charAt(left));
                left++;
                leng--;
            } else {
                set.add(c);
                right++;
                leng++;
            }
        }
        return Math.max(maxLength, leng);
    }
}
