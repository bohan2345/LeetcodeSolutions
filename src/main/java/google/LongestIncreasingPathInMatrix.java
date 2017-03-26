package google;

/**
 * <p>
 * Created by Bohan Zheng on 7/5/2016.
 *
 * @author Bohan Zheng
 */
public class LongestIncreasingPathInMatrix {
  public int findLongest(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int m = matrix.length, n = matrix[0].length;
    int[][] f = new int[m][n];
    int max = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        max = Math.max(max, search(matrix, f, i, j));
      }
    }
    return max;
  }

  public int search(int[][] matrix, int[][] f, int x, int y) {
    if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
      return 0;
    }
    if (f[x][y] != 0) {
      return f[x][y];
    }
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int max = 0;
    for (int i = 0; i < 4; i++) {
      if (x + dx[i] < 0 || y + dy[i] < 0 || x + dx[i] >= f.length || y + dy[i] >= f[0].length) {
        continue;
      }
      if (matrix[x][y] - matrix[x + dx[i]][y + dy[i]] < 0) {
        max = Math.max(max, search(matrix, f, x + dx[i], y + dy[i]));
      }
    }
    f[x][y] = max + 1;
    return f[x][y];
  }
}
