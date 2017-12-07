package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * <p>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * <p>
 * Created by Bohan Zheng on 5/11/2016.
 *
 * @author Bohan Zheng
 */
public class MinimumWindowSubstring {
//    public String minWindow(String s, String t) {
//        int left = 0, right = 0;
//        Map<Character, Integer> countMap = new HashMap<>();
//        scanString(countMap, t);
//        Map<Character, Integer> tmpMap = new HashMap<>(countMap);
//        while (right < s.length() && !tmpMap.isEmpty()) {
//            char c = s.charAt(right);
//            if (tmpMap.containsKey(c)) {
//                int count = tmpMap.get(c) - 1;
//                if (count == 0) {
//                    tmpMap.remove(c);
//                } else {
//                    tmpMap.put(c, count);
//                }
//            }
//            if (countMap.containsKey(c)) {
//                int count = countMap.get(c) - 1;
//                countMap.put(c, count);
//            }
//            right++;
//        }
//        if (!tmpMap.isEmpty()) {
//            return "";
//        }
//        int minLength = right;
//        int i = 0, j = right;
//        while (right <= s.length()) {
//            left = moveLeft(s, left, countMap);
//            if (minLength > right - left + 1) {
//                i = left - 1;
//                j = right;
//                minLength = j - i;
//            }
//            right = moveRight(s, right, countMap);
//        }
//        return s.substring(i, j);
//    }
//
//    private int moveLeft(String s, int left, Map<Character, Integer> map) {
//        while (left < s.length()) {
//            char c = s.charAt(left);
//            if (map.containsKey(c)) {
//                int count = map.get(c) + 1;
//                map.put(c, count);
//                if (count > 0) {
//                    return left + 1;
//                }
//            }
//            left++;
//        }
//        return left;
//    }
//
//    private int moveRight(String s, int right, Map<Character, Integer> map) {
//        while (right < s.length()) {
//            char c = s.charAt(right);
//            if (map.containsKey(c)) {
//                int count = map.get(c) - 1;
//                map.put(c, count);
//                if (count == 0) {
//                    return right + 1;
//                }
//            }
//            right++;
//        }
//        return right + 1;
//    }
//
//    private void scanString(Map<Character, Integer> countMap, String s) {
//        for (char c : s.toCharArray()) {
//            if (countMap.containsKey(c)) {
//                countMap.put(c, countMap.get(c) + 1);
//            } else {
//                countMap.put(c, 1);
//            }
//        }
//    }
    public String minWindow(String s, String t) {
        int[] map = new int[256];

        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        int match = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = -1;

        while (right < s.length()) {
            char in = s.charAt(right++);
            if (map[in] > 0) {
                match++;
            }
            map[in]--;

            while (match == t.length()) {
                if (minLen > right - left) {
                    minLen = right - left;
                    minStart = left;
                }
                char out = s.charAt(left++);
                map[out]++;
                if (map[out] > 0) {
                    match--;
                }
            }
        }
        return minStart == -1 ? "" : s.substring(minStart, minStart + minLen);
    }
}
