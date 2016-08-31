package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 5/23/2016.
 *
 * @author Bohan Zheng
 */
public class NumberofIslandsTest {
  @Test
  public void test() {
    NumberofIslands test = new NumberofIslands();
    char[][] gird = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
    assertEquals(1, test.numIslands(gird));
  }
}
