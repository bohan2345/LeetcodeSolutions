package google;

/**
 * <p>
 * Created by Bohan Zheng on 7/4/16.
 *
 * @author Bohan Zheng
 */
public class FileTransferTotalCost {
    public int totalCost(int[][] matrix) {
        int[][] costTable = new int[matrix.length][matrix[0].length];
        int totalSum = 0;
        for (int i = 1; i < matrix.length; i++) {
            costTable[i][0] = Math.min(costTable[i - 1][0] + matrix[i][0], i * matrix[i][0]);
            totalSum += costTable[i][0];
        }
        for (int j = 1; j < matrix[0].length; j++) {
            costTable[0][j] = Math.min(costTable[0][j - 1] + matrix[0][j], j * matrix[0][j]);
            totalSum += costTable[0][j];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                costTable[i][j] = Math.min((i + j) * matrix[i][j],
                        Math.min(costTable[i - 1][j] + matrix[i][j], costTable[i][j - 1] + matrix[i][j]));
                totalSum += costTable[i][j];
            }
        }
        return totalSum;
    }

    /**
     * Greedy:
     * from the start machine (i, j). transfer the file to the lowwest cost machine. cost1 = distance[(x1, y1), (i, j)] * matrix[x][y]
     * find the next machine (x2, y2) using machine (i, j) and (x1, y1) as start point. and so on.
     * #######################################################################
     * Proof:
     * let say we transfer file first to (x2, y2), then (x1, y1). cost2' >= cost1
     * cost2' = distance[p0, p2] * p2
     * then, cost1' = MIN(
     * #    distance[p1, p2] * p1 + distance[p0, p2] * p2,
     * #    distance[p0, p1] * p1
     * )
     * because distance[p0, p1] * p1 <= distance[p0, p2] * p2,
     * cost1' = distance[p0, p1] * p1;
     *
     * totalCost' = distance[p0, p1] * p1 + distance[p0, p2] * p2
     * ##########################################################################
     * cost1 = distance[p0, p1] * p1
     * cost2 = MIN(
     * #    distance[p1, p2] * p2 + distance[p0, p1] * p1,
     * #    distance[p0, p2] * p2
     * )
     * totalCost = cost1 + cost2 <= distance[p0, p1] * p1 + distance[p0, p2] * p2
     *
     * totalCost <= totalCost'
     *
     * So, this Greedy is one OPTIMAL solution.
     */


}
