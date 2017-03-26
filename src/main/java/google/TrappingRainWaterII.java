package google;

import java.util.PriorityQueue;

/**
 * <p>
 * Created by Bohan Zheng on 6/6/2016.
 *
 * @author Bohan Zheng
 */
public class TrappingRainWaterII {
  public int trapRainWater(int[][] heights) {
    int water = 0;
    PriorityQueue<Cell> heap = new PriorityQueue<>((c1, c2) -> {
      return new Integer(c1.height).compareTo(c2.height);
    });
    int n = heights.length;
    int m = heights[0].length;
    boolean[][] visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      heap.offer(new Cell(0, i, heights[i][0]));
      visited[i][0] = true;
      heap.offer(new Cell(m - 1, i, heights[i][m - 1]));
      visited[i][m - 1] = true;
    }
    for (int i = 0; i < m; i++) {
      heap.offer(new Cell(i, 0, heights[0][i]));
      visited[0][i] = true;
      heap.offer(new Cell(i, n - 1, heights[n - 1][i]));
      visited[n - 1][i] = true;
    }
    while (!heap.isEmpty()) {
      Cell min = heap.poll();
      // left
      if (min.x - 1 >= 0 && !visited[min.y][min.x - 1]) {
        water += Math.max(0, min.height - heights[min.y][min.x - 1]);
        heap.offer(new Cell(min.x - 1, min.y, Math.max(min.height, heights[min.y][min.x - 1])));
        visited[min.y][min.x - 1] = true;
      }
      // right
      if (min.x + 1 < m && !visited[min.y][min.x + 1]) {
        water += Math.max(0, min.height - heights[min.y][min.x + 1]);
        heap.offer(new Cell(min.x + 1, min.y, Math.max(min.height, heights[min.y][min.x + 1])));
        visited[min.y][min.x + 1] = true;
      }
      // up
      if (min.y - 1 >= 0 && !visited[min.y - 1][min.x]) {
        water += Math.max(0, min.height - heights[min.y - 1][min.x]);
        heap.offer(new Cell(min.x, min.y - 1, Math.max(min.height, heights[min.y - 1][min.x])));
        visited[min.y - 1][min.x] = true;
      }
      // down
      if (min.y + 1 < n && !visited[min.y + 1][min.x]) {
        water += Math.max(0, min.height - heights[min.y + 1][min.x]);
        heap.offer(new Cell(min.x, min.y + 1, Math.max(min.height, heights[min.y + 1][min.x])));
        visited[min.y + 1][min.x] = true;
      }
    }
    return water;
  }

  private class Cell {
    int x, y, height;

    Cell(int x, int y, int height) {
      this.x = x;
      this.y = y;
      this.height = height;
    }
  }
}
