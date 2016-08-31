package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
 * You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
 * <p>
 * Created by Bohan Zheng on 5/20/2016.
 *
 * @author Bohan Zheng
 */
public class ShortestDistancefromAllBuildings {
  /**
   * do bfs from each building, add distance.
   * key point is have a seperate matrix track if the empty land is reachable from all building
   */
  public int shortestDistance(int[][] grid) {
    int n = grid.length, m = grid[0].length;

    int[][] visited = new int[n][m];
    int[][] distance = new int[n][m];
    int totalCityNum = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          totalCityNum++;
          bfs(grid, distance, visited, new Coordinate(i, j));
        }
      }
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (visited[i][j] == totalCityNum && distance[i][j] < min) {
          min = distance[i][j];
        }
      }
    }
    return min;
  }

  private void bfs(int[][] grid, int[][] distance, int[][] visited, Coordinate co) {

    Queue<Coordinate> queue = new LinkedList<>();
    queue.offer(co);
    int dist = 0, next = 0, cur = 1;
    boolean[][] tmp = new boolean[grid.length][grid[0].length];
    while (!queue.isEmpty()) {
      Coordinate coordinate = queue.poll();
      cur--;
      int i = coordinate.x;
      int j = coordinate.y;
      if (i - 1 >= 0 && grid[i - 1][j] == 0 && !tmp[i - 1][j]) {
        queue.offer(new Coordinate(i - 1, j));
        visited[i - 1][j] += 1;
        tmp[i - 1][j] = true;
        next++;
      }
      if (i + 1 < grid.length && grid[i + 1][j] == 0 && !tmp[i + 1][j]) {
        queue.offer(new Coordinate(i + 1, j));
        visited[i + 1][j] += 1;
        tmp[i + 1][j] = true;
        next++;
      }
      if (j - 1 >= 0 && grid[i][j - 1] == 0 && !tmp[i][j - 1]) {
        queue.offer(new Coordinate(i, j - 1));
        visited[i][j - 1] += 1;
        tmp[i][j - 1] = true;
        next++;
      }
      if (j + 1 < grid[i].length && grid[i][j + 1] == 0 && !tmp[i][j + 1]) {
        queue.offer(new Coordinate(i, j + 1));
        visited[i][j + 1] += 1;
        tmp[i][j + 1] = true;
        next++;
      }
      distance[i][j] += dist;
      if (cur == 0) {
        cur = next;
        next = 0;
        dist++;
      }
    }
  }

  private class Coordinate {
    int x;
    int y;

    Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
