package google.dp;

/**
 * Created by bohan on 8/30/2016.
 *
 * @author Bohan Zheng
 */
public class LongestCommonSubsequence {
  public int longestCommonSubsequence(String A, String B) {
    int[][] f = new int[A.length() + 1][B.length() + 1];
    for (int i = 1; i <= A.length(); i++) {
      for (int j = 1; j <= B.length(); j++) {
        if (A.charAt(i - 1) == B.charAt(j - 1)) {
          f[i][j] = f[i - 1][j - 1] + 1;
        } else {
          f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
        }
      }
    }
    return f[A.length()][B.length()];
  }
}
