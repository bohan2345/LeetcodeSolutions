package string;

/**
 * Implement strStr().
 * <p>
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Created by Bohan Zheng on 4/21/2016.
 *
 * @author Bohan Zheng
 */
public class StrStr {
  public int strStr(String haystack, String needle) {
    if (needle == null || needle.length() == 0)
      return 0;
    if (haystack == null || haystack.length() == 0)
      return -1;
    char[] h = haystack.toCharArray(), n = needle.toCharArray();
    for (int i = 0; i <= h.length - n.length; i++) {
      int j = 0;
      for (; j < n.length && h[i + j] == n[j]; j++) ;
      if (j == n.length) {
        return i;
      }
    }
    return -1;
  }

  /**
   * KMP
   */
}
