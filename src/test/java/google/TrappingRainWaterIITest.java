package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 6/6/2016.
 *
 * @author Bohan Zheng
 */
public class TrappingRainWaterIITest {
  @Test
  public void test() {
    int[][] heights = {{12, 13, 0, 12},
        {13, 4, 13, 12},
        {13, 8, 10, 12},
        {12, 13, 12, 12},
        {13, 13, 13, 13}};
    TrappingRainWaterII test = new TrappingRainWaterII();
    assertEquals(14, test.trapRainWater(heights));
  }
}
