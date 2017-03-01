package google.dp;

/**
 * Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?
 * Notice:
 * You can not divide any item into small pieces.
 * Example
 * If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5],
 * so that the max size we can fill this backpack is 10. If the backpack size is 12.
 * we can select [2, 3, 7] so that we can fulfill the backpack.
 * You function should return the max size we can fill in the given backpack.
 * <p>
 * Created by Bohan Zheng on 6/23/2016.
 *
 * @author Bohan Zheng
 */
public class Backpack {
  /**
   * f(i, j) denotes with the first i items can fill up the backpack of size i
   * f(i) = f(i - 1, j) || f(i - 1, j - A[i - 1])
   *
   * @param m: An integer m denotes the size of a backpack
   * @param A: Given n items with size A[i]
   * @return The maximum size
   */
  public int backPack(int m, int[] A) {
    // write your code here
    boolean[][] f = new boolean[A.length + 1][m + 1];
    for (int i = 0; i <= A.length; i++) {
      f[i][0] = true;
    }
    for (int i = 1; i <= A.length; i++) {
      for (int j = 0; j <= m; j++) {
        if (j - A[i - 1] >= 0) {
          f[i][j] = f[i - 1][j] || f[i - 1][j - A[i - 1]];
        } else {
          f[i][j] = f[i - 1][j];
        }
      }
    }
    for (int j = m; j >= 0; j--) {
      if (f[A.length][j]) return j;
    }
    return 0;
  }
}
