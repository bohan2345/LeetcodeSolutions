package google.dp;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * <p>
 * Return all such possible sentences.
 * <p>
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * <p>
 * A solution is ["cats and dog", "cat sand dog"].
 * <p>
 * Created by Bohan Zheng on 7/5/16.
 *
 * @author Bohan Zheng
 */
public class WordBreakII {
  public List<String> wordBreakII(String s, Set<String> dict) {
    return search(s, dict, new HashMap<>());
  }

  private List<String> search(String s, Set<String> dict, Map<String, List<String>> cache) {
    if (cache.containsKey(s)) return cache.get(s);
    List<String> res = new ArrayList<>();
    if (dict.contains(s)) {
      res.add(s);
    }
    for (int i = 1; i < s.length(); i++) {
      String sub = s.substring(i);
      if (dict.contains(sub)) {
        List<String> tmp = search(s.substring(0, i), dict, cache);
        sub = " " + sub;
        for (String tmpstr : tmp) {
          String str = tmpstr + sub;
          res.add(str);
        }
      }
    }
    cache.put(s, res);
    return res;
  }
}
