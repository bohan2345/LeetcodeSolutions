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
                longestPath[i][j] = -1;
            }
        }

        int[][] visited = new int[matrix.length][matrix[0].length];
        int max = 0;
        int[] position = {0, 0};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int tmpmax = search(matrix, new int[]{i, j}, longestPath, visited);
                if (tmpmax > max) {
                    max = tmpmax;
                    position[0] = i;
                    position[1] = j;
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

    private int search(int[][] matrix, int[] position, int[][] longestPath, int[][] visited) {
        int i = position[0], j = position[1];
        if (longestPath[i][j] != -1) {
            return longestPath[i][j];
        }
        int max = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        for (int x = 0; x < 4; x++) {
            int di = i + dx[x];
            int dj = j + dy[x];
            if (di == -1 || dj == -1 || di == matrix.length || dj == matrix[0].length || visited[di][dj] == 1) {
                continue;
            }
            int length = 1;
            if (matrix[i][j] < matrix[di][dj]) {
                visited[i][j] = 1;
                length = search(matrix, new int[]{di, dj}, longestPath, visited) + 1;
                visited[i][j] = 0;
            }
            max = Math.max(length, max);
        }
        longestPath[i][j] = max;
        return max;
    }
}
