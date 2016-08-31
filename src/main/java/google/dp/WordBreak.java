package google.dp;

import java.util.Set;

/**
 * <p>
 * Created by Bohan Zheng on 7/5/2016.
 *
 * @author Bohan Zheng
 */
public class WordBreak {
  /**
   * f(n) denotes str.substring(0, n) can break;
   * f(n) = f(n - k) && wordDict.contains(str.substring(n - k, n)); 0 < k <= n
   */
  public boolean wordBreak(String s, Set<String> wordDict) {
    boolean[] f = new boolean[s.length() + 1];
    f[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      boolean x = false;
      for (int k = 1; k <= i; k++) {
        x = x || (f[i - k] && wordDict.contains(s.substring(i - k, i)));
      }
      f[i] = x;
    }
    return f[s.length()];
  }
}
