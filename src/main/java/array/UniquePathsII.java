package array;

/**
 * Follow up for "Unique Paths":<p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?<p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.<p>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.<p>
 * [<br>
 * [0,0,0],<br>
 * [0,1,0],<br>
 * [0,0,0]<br>
 * ]<p>
 * The total number of unique paths is 2.<p>
 * Note: m and n will be at most 100.<p>
 * <br>
 * Created by Bohan Zheng on 9/2/2015.
 *
 * @author Bohan Zheng
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] tmp = new int[n];
        int totalPaths = 0;
        tmp[0] = 1;
        for (int i = 0; i < m; i++) {
            totalPaths = obstacleGrid[i][0] == 1 ? 0 : tmp[0];
            tmp[0] = totalPaths;
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    totalPaths = 0;
                    tmp[j] = 0;
                    continue;
                }
                totalPaths += tmp[j];
                tmp[j] = totalPaths;
            }
        }
        return totalPaths;
    }

    public int uniquePathsWithObstaclesII(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            tmp[i] = 1;
        }
        int[] startPath = new int[m];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            startPath[i] = 1;
        }
        int totalPath = tmp[n - 1];
        for (int i = 1; i < m; i++) {
            totalPath = startPath[i];
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    tmp[j] = 0;
                    totalPath = 0;
                    continue;
                }
                totalPath = totalPath + tmp[j];
                tmp[j] = totalPath;
            }
        }
        return totalPath;
    }
}
