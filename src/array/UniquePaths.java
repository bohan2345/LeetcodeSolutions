package array;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).<br>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).<br>
 * How many possible unique paths are there?<br>
 * <b>Note</b>: m and n will be at most 100. <p>
 * <br>
 * Created by Bohan Zheng on 9/2/2015.
 *
 * @author Bohan Zheng
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = 1;
        }
        int totalPaths = 1;
        for (int i = 1; i < m; i++) {
            int path = 1;
            for (int j = 1; j < n; j++) {
                totalPaths = path + tmp[j];
                path = totalPaths;
                tmp[j] = totalPaths;
            }
        }
        return totalPaths;
    }
}
