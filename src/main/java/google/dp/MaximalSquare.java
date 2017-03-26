package google.dp;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
 * <p>
 * For example, given the following matrix:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 * <p>
 * Created by Bohan Zheng on 6/21/2016.
 *
 * @author Bohan Zheng
 */
public class MaximalSquare {
  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int m = matrix.length, n = matrix[0].length;
    int max = 0;
    int[][] table = new int[m][n];
    for (int i = 0; i < m; i++) {
      table[i][0] = matrix[i][0] == '1' ? 1 : 0;
      max = Math.max(max, table[i][0]);
    }
    for (int j = 0; j < n; j++) {
      table[0][j] = matrix[0][j] == '1' ? 1 : 0;
      max = Math.max(max, table[0][j]);
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == '0') {
          continue;
        }
        table[i][j] = Math.min(table[i - 1][j - 1], Math.min(table[i - 1][j], table[i][j - 1])) + 1;
        max = Math.max(max, table[i][j]);
      }
    }
    return max * max;
  }
}
