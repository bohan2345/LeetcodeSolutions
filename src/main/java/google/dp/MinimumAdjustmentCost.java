package google.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.
 * <p>
 * If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|
 * <p>
 * Notice
 * <p>
 * You can assume each number in the array is a positive integer and not greater than 100.
 * <p>
 * Example
 * Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.
 * <p>
 * Return 2
 * <p>
 * Created by Bohan Zheng on 6/25/16.
 *
 * @author Bohan Zheng
 */
public class MinimumAdjustmentCost {
  /**
   * f(i, j) denotes the minimum adjustment cost by adjust the ith element to value j
   * f(i, j) = MIN(f(i - 1, k) + |j - A[i]|), |j - k| <= target
   *
   * @param A:      An integer array.
   * @param target: An integer.
   */
  public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
    int max = 0;
    for (int n : A) {
      max = Math.max(max, n);
    }
    int[][] f = new int[A.size()][max + 1];

    for (int j = 0; j <= max; j++) {
      f[0][j] = Math.abs(A.get(0) - j);
    }
    List<Integer> B = new ArrayList<>(A.size());
    for (int i = 1; i < A.size(); i++) {
      for (int j = 0; j <= max; j++) {
        int minCost = Integer.MAX_VALUE;
        for (int k = Math.max(j - target, 0); k <= j + target; k++) {
          if (k < 0 || k > max) {
            continue;
          }
          minCost = Math.min(f[i - 1][k] + Math.abs(j - A.get(i)), minCost);
        }
        f[i][j] = minCost;
        //B.add(j);
      }
    }
    int len = A.size();
    int overAllMinCost = f[len - 1][0];
    for (int j = 0; j <= max; j++) {
      overAllMinCost = Math.min(overAllMinCost, f[len - 1][j]);
    }
    return overAllMinCost;
  }

}
