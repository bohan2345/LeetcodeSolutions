package google.dp;

/**
 * Created by bohan on 8/30/2016.
 *
 * @author Bohan Zheng
 */
public class PalindromePartitioningII {
  /**
   * f(i) denotes min cut of s.substring(0, i)
   * f(i) = min(f(k) + 1), s.substring(k, i) is palindrome, 0 < k < i
   */
  public int minCut(String s) {
    int[] f = new int[s.length() + 1];

    for (int i = 1; i <= s.length(); i++) {
      if (isPalindrome(s.substring(0, i))) {
        f[i] = 0;
        continue;
      }
      int min = s.length();
      for (int k = 1; k < i; k++) {
        if (isPalindrome(s.substring(k, i))) {
          min = Math.min(min, f[k] + 1);
        }
      }
      f[i] = min;
    }
    return f[s.length()];
  }

  private boolean isPalindrome(String s) {
    int start = 0, end = s.length() - 1;
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }
}
