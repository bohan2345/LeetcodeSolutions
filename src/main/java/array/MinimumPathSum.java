package array;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the
 * sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.<p>
 * <br>
 * Created by Bohan Zheng on 9/2/2015.
 *
 * @author Bohan Zheng
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] tmp = new int[n];
        tmp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            tmp[i] = tmp[i - 1] + grid[0][i];
        }
        int minPath = tmp[n - 1];
        for (int i = 1; i < m; i++) {
            int path = grid[i][0] + tmp[0];
            tmp[0] = path;
            for (int j = 1; j < n; j++) {
                minPath = Math.min(tmp[j], path) + grid[i][j];
                tmp[j] = minPath;
                path = minPath;
            }
        }
        return minPath;
    }
}
