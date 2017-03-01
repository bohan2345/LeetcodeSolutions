package google;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string str and a number k, find the longest substring contains at most k unique characters.
 * For example,
 * Given str = "eceha", k = 2
 * Return "ece"
 * <p>
 * Created by Bohan Zheng on 5/12/2016.
 *
 * @author Bohan Zheng
 */
public class LongestSubstringWithKUniqueCharacters {
  public String longestSubstring(String str, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int left = 0, right = 0;
    int maxLength = 0, a = 0, b = 0;
    while (right < str.length()) {
      if (map.keySet().size() > k) {
        //moveLeft
        char c = str.charAt(left);
        int count = map.get(c) - 1;
        if (count == 0) {
          map.remove(c);
        } else {
          map.put(c, count);
        }
        left++;
      } else {
        //moveRight
        char c = str.charAt(right);
        if (map.containsKey(c)) {
          map.put(c, map.get(c) + 1);
        } else {
          map.put(c, 1);
        }
        if (maxLength < right - left) {
          maxLength = right - left;
          a = right;
          b = left;
        }
        right++;
      }
    }
    return str.substring(b, a);
  }
}
