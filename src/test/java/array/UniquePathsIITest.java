package array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <br>
 * Created by Bohan Zheng on 9/2/2015.
 *
 * @author Bohan Zheng
 */
public class UniquePathsIITest {
  UniquePathsII test = new UniquePathsII();

  @Test
  public void test() {
    int[][] obstacleGrid = new int[3][3];
    obstacleGrid[2][2] = 1;
    assertEquals(0, test.uniquePathsWithObstacles(obstacleGrid));
  }

  @Test
  public void test2() {
    int[][] obstacleGrid = new int[1][1];
    obstacleGrid[0][0] = 1;
    assertEquals(0, test.uniquePathsWithObstacles(obstacleGrid));
  }

  @Test
  public void test3() {
    int[][] obstacleGrid = new int[4][4];
    obstacleGrid[1][1] = 1;
    obstacleGrid[1][2] = 1;
    assertEquals(5, test.uniquePathsWithObstacles(obstacleGrid));
  }

  @Test
  public void test4() {
    int[][] obstacleGrid = new int[1][4];
    obstacleGrid[0][1] = 1;
    assertEquals(0, test.uniquePathsWithObstacles(obstacleGrid));
  }

  @Test
  public void test5() {
    int[][] obstacleGrid = new int[4][1];
    obstacleGrid[0][0] = 1;
    assertEquals(0, test.uniquePathsWithObstacles(obstacleGrid));
  }

  @Test
  public void test6() {
    int[][] obstacleGrid = {{0}, {1}};
    assertEquals(0, test.uniquePathsWithObstacles(obstacleGrid));
  }

  @Test
  public void test7() {
    int[][] obstacleGrid = {{0, 0}, {1, 1}, {0, 0}};
    assertEquals(0, test.uniquePathsWithObstaclesII(obstacleGrid));
  }
}
