package bfs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 5/20/2016.
 *
 * @author Bohan Zheng
 */
public class ShortestDistancefromAllBuildingsTest {
  @Test
  public void test() {
    ShortestDistancefromAllBuildings test = new ShortestDistancefromAllBuildings();
    int[][] grid = {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
    assertEquals(7, test.shortestDistance(grid));
  }
}
