package google.dp;

/**
 * Given n distinct positive integers, integer k (k <= n) and a number target.
 * <p>
 * Find k numbers where sum is target. Calculate how many solutions there are?
 * <p>
 * Example
 * Given [1,2,3,4], k = 2, target = 5.
 * There are 2 solutions: [1,4] and [2,3].
 * Return 2.
 * <p>
 * Created by Bohan Zheng on 6/25/16.
 *
 * @author Bohan Zheng
 */
public class KSum {
  /**
   * f(i, j, k) denotes choose k numbers for the first i numbers sum up to target j, total number of feasible solutions
   * f(i, j, k) = f(i - 1, j, k) + f(i - 1, j - A[i], k - 1)
   *
   * @param A:      an integer array.
   * @param k:      a positive integer (k <= length(A))
   * @param target: a integer
   * @return an integer
   */
  public int kSum(int A[], int k, int target) {
    // write your code here
    int[][][] f = new int[A.length + 1][target + 1][k + 1];
    for (int i = 0; i < A.length + 1; i++) {
      f[i][0][0] = 1;
    }
    for (int i = 1; i <= A.length; i++) {
      for (int j = 0; j <= target; j++) {
        for (int l = 1; l <= k; l++) {
          f[i][j][l] = f[i - 1][j][l];
          if (j - A[i - 1] >= 0) {
            f[i][j][l] += f[i - 1][j - A[i - 1]][l - 1];
          }
        }
      }
    }
    return f[A.length][target][k];
  }
}
