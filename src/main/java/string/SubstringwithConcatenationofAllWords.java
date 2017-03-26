package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in
 * words exactly once and without any intervening characters.
 * <p>
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * <p>
 * You should return the indices: [0,9].
 * (order does not matter).
 * <p>
 * Created by Bohan Zheng on 3/9/2016.
 *
 * @author Bohan Zheng
 */
public class SubstringwithConcatenationofAllWords {
  public List<Integer> findSubstring(String s, String[] words) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      if (map.containsKey(word)) {
        map.put(word, map.get(word) + 1);
      } else {
        map.put(word, 1);
      }
    }
    List<Integer> res = new ArrayList<>();
    int leng = words[0].length();
    for (int i = 0; i <= s.length() - leng * words.length; i++) {
      String substring = s.substring(i, i + leng);
      if (map.containsKey(substring) && isContainingAllWords(s, new HashMap<>(map), leng, i)) {
        res.add(i);
      }
    }
    return res;
  }

  private boolean isContainingAllWords(String s, Map<String, Integer> map, int leng, int i) {
    while (i + leng <= s.length() && !map.isEmpty()) {
      String substring = s.substring(i, i + leng);
      if (map.containsKey(substring)) {
        int count = map.get(substring) - 1;
        if (count == 0) {
          map.remove(substring);
        } else {
          map.put(substring, count);
        }
      } else {
        return false;
      }
      i = i + leng;
    }
    return map.isEmpty();
  }

  public List<Integer> findSubstringII(String s, String[] words) {
    ArrayList<Integer> result = new ArrayList<>();
    if (s == null || s.length() == 0 || words == null || words.length == 0) {
      return result;
    }

    //frequency of words
    HashMap<String, Integer> map = new HashMap<>();
    for (String w : words) {
      if (map.containsKey(w)) {
        map.put(w, map.get(w) + 1);
      } else {
        map.put(w, 1);
      }
    }

    int len = words[0].length();

    for (int j = 0; j < len; j++) {
      HashMap<String, Integer> currentMap = new HashMap<>();
      int start = j;//start index of start
      int count = 0;//count totoal qualified words so far

      for (int i = j; i <= s.length() - len; i = i + len) {
        String sub = s.substring(i, i + len);
        if (map.containsKey(sub)) {
          //set frequency in current map
          if (currentMap.containsKey(sub)) {
            currentMap.put(sub, currentMap.get(sub) + 1);
          } else {
            currentMap.put(sub, 1);
          }

          count++;

          while (currentMap.get(sub) > map.get(sub)) {
            String left = s.substring(start, start + len);
            currentMap.put(left, currentMap.get(left) - 1);

            count--;
            start = start + len;
          }

          if (count == words.length) {
            result.add(start); //add to result

            //shift right and reset currentMap, count & start point
            String left = s.substring(start, start + len);
            currentMap.put(left, currentMap.get(left) - 1);
            count--;
            start = start + len;
          }
        } else {
          currentMap.clear();
          start = i + len;
          count = 0;
        }
      }
    }
    return result;
  }
}
