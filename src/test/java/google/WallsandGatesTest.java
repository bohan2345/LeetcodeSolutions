package google;

import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 7/10/16.
 *
 * @author Bohan Zheng
 */
public class WallsandGatesTest {
  @Test
  public void test() {
    WallsandGates test = new WallsandGates();
    int[][] array = {{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1},
        {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};
    test.wallsAndGates(array);

  }
}
