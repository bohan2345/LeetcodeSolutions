package google.dp;

/**
 * 在一个圆形操场的四周摆放着n堆石子(n<= 100)，现要将石子有次序地合并成一堆。规定每次只能选取相邻的两堆合并成新的一堆,
 * 并将新的一堆的石子数,记为该次合并的得分。
 * 求最小得分。
 * 1. 第一个和最后一个不相连
 * 2. 第一个和最后一个相连
 * <p>
 * Created by Bohan Zheng on 6/22/2016.
 *
 * @author Bohan Zheng
 */
public class StoneGame {
  /**
   * f(i, j) denotes the min cost to combine all stones from i to j
   * SUM(i, j) total number of stones from i to j
   * f(i, j) = MIN(f(i, k) + f(k + 1, j)) + SUM(i, j), i <= k < j
   */
  public int minCost(int[] stones) {
    int n = stones.length;
    int[][] f = new int[n][n];
    int[][] sum = new int[n][n];
    for (int i = 0; i < n; i++) {
      sum[i][i] = stones[i];
      for (int j = i + 1; j < n; j++) {
        sum[i][j] = sum[i][j - 1] + stones[j];
      }
    }
    for (int i = n - 2; i >= 0; i--) {
      for (int j = i + 1; j < n; j++) {
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
          min = Math.min(min, f[i][k] + f[k + 1][j]);
        }
        f[i][j] = min + sum[i][j];
      }
    }
    return f[0][n - 1];
  }
}
