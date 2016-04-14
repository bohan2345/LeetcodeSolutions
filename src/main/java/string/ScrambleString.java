package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * Below is one possible representation of s1 = "great":
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * We say that "rgeat" is a scrambled string of "great".
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * We say that "rgtae" is a scrambled string of "great".
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * https://leetcode.com/problems/scramble-string/
 * <p>
 * Created by Bohan Zheng on 4/13/2016.
 *
 * @author Bohan Zheng
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int leng1 = s1.length(), leng2 = s2.length();
        if (leng1 != leng2 || !hasSameCharacters(s1, s2)) {
            return false;
        }
        for (int i = 1; i < leng1; ++i) {
            String sub11 = s1.substring(0, i);
            String sub12 = s1.substring(i);
            String sub21 = s2.substring(0, i);
            String sub22 = s2.substring(i);
            if (isScramble(sub11, sub21) && isScramble(sub12, sub22)) {
                return true;
            }
            sub21 = s2.substring(leng2 - i, leng2);
            sub22 = s2.substring(0, leng2 - i);
            if (isScramble(sub11, sub21) && isScramble(sub12, sub22)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSameCharacters(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); ++i) {
            char c = s1.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < s2.length(); ++i) {
            char c = s2.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c) - 1;
                if (count == 0) {
                    map.remove(c);
                } else {
                    map.put(c, count);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
}
