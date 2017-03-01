package google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation
 * which turns the water at position (row, col) into a land. Given a list of positions to operate, count the
 * number of islands after each addLand operation. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example:
 * <p>
 * Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
 * <p>
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 * <p>
 * 1 0 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 * <p>
 * 1 1 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 * <p>
 * 1 1 0
 * 0 0 1   Number of islands = 2
 * 0 0 0
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 * <p>
 * 1 1 0
 * 0 0 1   Number of islands = 3
 * 0 1 0
 * We return the result as an array: [1, 1, 2, 3]
 * <p>
 * Created by Bohan Zheng on 5/23/2016.
 *
 * @author Bohan Zheng
 */
public class NumberofIslandsII {
  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    DisjointSet ds = new DisjointSet(m * n);
    Set<Integer> islands = new HashSet<>(positions.length);
    List<Integer> res = new ArrayList<>(positions.length);
    int island = 0;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    for (int[] position : positions) {
      island++;
      int a = position[0] * n + position[1];
      for (int d = 0; d < 4; d++) {
        int[] adjcentPosition = {position[0] + dx[d], position[1] + dy[d]};
        if (adjcentPosition[0] < 0 || adjcentPosition[1] < 0 || adjcentPosition[0] >= m || adjcentPosition[1] >= n) {
          continue;
        }
        int b = adjcentPosition[0] * n + adjcentPosition[1];
        if (islands.contains(b) && ds.find(a) != ds.find(b)) {
          ds.union(a, b);
          island--;
        }
      }
      islands.add(a);
      res.add(island);
    }
    return res;
  }

  private class DisjointSet {
    private int[] positions;

    private DisjointSet(int n) {
      positions = new int[n];
      int counter = 0;
      for (int i = 0; i < n; i++) {
        positions[i] = counter++;
      }
    }

    private void union(int a, int b) {
      int tmp = find(a);
      positions[tmp] = find(b);
    }

    private int find(int a) {
      while (a != positions[a]) {
        positions[a] = positions[positions[a]];
        a = positions[a];
      }
      return a;
    }
  }
}
