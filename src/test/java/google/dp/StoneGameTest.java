package google.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 6/22/2016.
 *
 * @author Bohan Zheng
 */
public class StoneGameTest {
  @Test
  public void test() {
    StoneGame test = new StoneGame();
    int[] stones = {1, 2, 3};
    assertEquals(9, test.minCost(stones));
  }

  @Test
  public void test2() {
    StoneGame test = new StoneGame();
    int[] stones = {3, 4, 5, 6};
    assertEquals(36, test.minCost(stones));
  }
}
