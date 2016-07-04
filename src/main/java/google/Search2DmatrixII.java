package google;

/**
 * 在vertical和horizontal分别有序的matrix里找一个数，最优O(n).
 * <p>
 * Created by Bohan Zheng on 7/3/16.
 *
 * @author Bohan Zheng
 */
public class Search2DmatrixII {
    /**
     * @param matrix: A list of lists of integers
     * @param target A number you want to search in the matrix
     * @return An integer indicate the occurrence of target in the given matrix
     */
    public int search(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length - 1, n = 0;
        int count = 0;
        while (m >= 0 && n < matrix[0].length) {
            if (matrix[m][n] == target) {
                count++;
                m--;
                n++;
            } else if (matrix[m][n] > target) {
                m--;
            } else {
                n++;
            }
        }
        return count;
    }
}
