package google;

import java.util.Arrays;

/**
 * <p>
 * Created by Bohan Zheng on 7/10/16.
 *
 * @author Bohan Zheng
 */
public class LargestMultipleStringsWithDistinctCharactor {
  public int max(String[] strs) {
    Arrays.sort(strs, (s1, s2) -> s1.length() - s2.length());
    int[] strMaps = new int[strs.length];
    for (int i = 0; i < strs.length; i++) {
      strMaps[i] = getBinaryNumber(strs[i]);
    }
    int j = strs.length - 2;
    while (j >= 0) {
      for (int i = strs.length - 1; i > j; i--) {
        if ((strMaps[i] & strMaps[j]) == 0) {
          return strs[i].length() * strs[j].length();
        }
      }
      j--;
    }
    return 0;
  }

  private int getBinaryNumber(String str) {
    byte[] res = new byte[26];
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      res[c - 'a'] = 1;
    }
    int j = 1;
    int n = 0;
    for (byte re : res) {
      n += re == 1 ? j : 0;
      j *= 2;
    }
    return n;
  }
}
