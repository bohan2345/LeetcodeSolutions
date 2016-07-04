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
            costTable[i][0] = costTable[i - 1][0] + i * matrix[i][0];
            totalSum += costTable[i][0];
        }
        for (int j = 1; j < matrix[0].length; j++) {
            costTable[0][j] = costTable[0][j - 1] + j * matrix[0][j];
            totalSum += costTable[0][j];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                costTable[i][j] = Math.min(costTable[i - 1][j], costTable[i][j - 1]) + (i + j) * matrix[i][j];
                totalSum += costTable[i][j];
            }
        }
        return totalSum;
    }
}
