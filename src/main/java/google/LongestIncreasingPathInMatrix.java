package google;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Created by Bohan Zheng on 6/8/2016.
 *
 * @author Bohan Zheng
 */
public class LongestIncreasingPathInMatrix {
    /*
      longest path from position [x, y],
      f(x, y) = f(x - 1, y) + 1 if matrix[x][y] < matrix[x - 1][y]
      same for other three direction. Then get the max from the four value;
     */
    public List<Integer> findLongest(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] longestPath = new int[m][n];
        // init all value to 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                longestPath[i][j] = 1;
            }
        }
        int[] position = {0, 0};
        int max = 0;
        // scan for up and left;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0 && matrix[i][j] < matrix[i - 1][j])
                    longestPath[i][j] = Math.max(longestPath[i - 1][j] + 1, longestPath[i][j]);
                if (j - 1 >= 0 && matrix[i][j] < matrix[i][j - 1])
                    longestPath[i][j] = Math.max(longestPath[i][j - 1] + 1, longestPath[i][j]);
                if (longestPath[i][j] > max) {
                    position[0] = i;
                    position[1] = j;
                    max = longestPath[i][j];
                }
            }
        }
        // scan for right and down
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m && matrix[i][j] < matrix[i + 1][j])
                    longestPath[i][j] = Math.max(longestPath[i + 1][j] + 1, longestPath[i][j]);
                if (j + 1 < n && matrix[i][j] < matrix[i][j + 1])
                    longestPath[i][j] = Math.max(longestPath[i][j + 1] + 1, longestPath[i][j]);
                if (longestPath[i][j] > max) {
                    position[0] = i;
                    position[1] = j;
                    max = longestPath[i][j];
                }
            }
        }
        List<Integer> path = new ArrayList<>(max);
        while (max > 0) {
            max--;
            int i = position[0], j = position[1];
            path.add(matrix[i][j]);
            if (i > 0 && longestPath[i - 1][j] == max) {
                position[0] = i - 1;
                position[1] = j;
            } else if (i + 1 < m && longestPath[i + 1][j] == max) {
                position[0] = i + 1;
                position[1] = j;
            } else if (j > 0 && longestPath[i][j - 1] == max) {
                position[0] = i;
                position[1] = j - 1;
            } else if (j + 1 < n && longestPath[i][j + 1] == max) {
                position[0] = i;
                position[1] = j + 1;
            }
        }
        return path;
    }
}
