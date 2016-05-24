package google;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * <p>
 * Example 2:
 * <p>
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 * <p>
 * Created by Bohan Zheng on 5/23/2016.
 *
 * @author Bohan Zheng
 */
public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int num = 0;
        if (grid == null || grid.length == 0)
            return num;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '2';
        if (i + 1 < grid.length && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j);
        }
        if (j + 1 < grid[i].length && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1);
        }
    }
}
