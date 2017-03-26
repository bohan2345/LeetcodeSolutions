package google;

/**
 * <p>
 * Created by Bohan Zheng on 7/4/16.
 *
 * @author Bohan Zheng
 */
public class FileTransferTotalCost {
  /**
   * Greedy:
   * from the start machine p0. transfer the file to the lowwest cost machine. cost1 = distance[p0, p1] * p1
   * find the next machine p2 using machine p0 and p1 as start point. and so on.
   * #######################################################################
   * Proof:
   * let say we transfer file first to p2, then p1. cost2' >= cost1
   * cost2' = distance[p0, p2] * p2
   * then, cost1' = MIN(
   * #    distance[p1, p2] * p1 + distance[p0, p2] * p2,
   * #    distance[p0, p1] * p1
   * )
   * because distance[p0, p1] * p1 <= distance[p0, p2] * p2,
   * cost1' = distance[p0, p1] * p1;
   * <p>
   * totalCost' = distance[p0, p1] * p1 + distance[p0, p2] * p2
   * ##########################################################################
   * cost1 = distance[p0, p1] * p1
   * cost2 = MIN(
   * #    distance[p1, p2] * p2 + distance[p0, p1] * p1,
   * #    distance[p0, p2] * p2
   * )
   * totalCost = cost1 + cost2 <= distance[p0, p1] * p1 + distance[p0, p2] * p2
   * <p>
   * totalCost <= totalCost'
   * <p>
   * So, this Greedy is one OPTIMAL solution.
   */
  public int totalCost(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] minCostMatrix = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++)
        minCostMatrix[i][j] = Integer.MAX_VALUE;
    }
    int[] p = {0, 0};
    minCostMatrix[0][0] = 0;
    int sum = 0;
    boolean[][] transfered = new boolean[m][n];
    transfered[0][0] = true;
    for (int i = 0; i < m * n; i++) {
      p = updateMinCostMatrix(matrix, minCostMatrix, transfered, p[0], p[1]);
      transfered[p[0]][p[1]] = true;
      sum += minCostMatrix[p[0]][p[1]];
    }
    return sum;
  }

  private int distance(int x1, int y1, int x2, int y2) {
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
  }

  /**
   * tansfer from (x, y) to updateMinCostMatrix
   *
   * @return min cost position
   */
  private int[] updateMinCostMatrix(int[][] matrix, int[][] minCostMatrix, boolean[][] transfered, int x, int y) {
    int[] pos = {0, 0};
    int minvalue = Integer.MAX_VALUE;
//        for (int i = 0; i < minCostMatrix.length; i++) {
//            for (int j = 0; j < minCostMatrix[0].length; j++) {
//                if (!transfered[i][j] && minCostMatrix[i][j] < minvalue) {
//                    minvalue = minCostMatrix[i][j];
//                    pos[0] = i;
//                    pos[1] = j;
//                }
//            }
//        }
    for (int i = 0; i < minCostMatrix.length; i++) {
      for (int j = 0; j < minCostMatrix[0].length; j++) {
        if (transfered[i][j]) {
          continue;
        }
        if (minCostMatrix[i][j] < minvalue) {
          minvalue = minCostMatrix[i][j];
          pos[0] = i;
          pos[1] = j;
        }
        int cost = distance(i, j, x, y) * matrix[i][j] + minCostMatrix[x][y];
        if (cost < minCostMatrix[i][j]) {
          minCostMatrix[i][j] = cost;
        }
        if (cost < minvalue) {
          minvalue = minCostMatrix[i][j];
          pos[0] = i;
          pos[1] = j;
        }
      }
    }
    return pos;
  }
}
