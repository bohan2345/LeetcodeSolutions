package google.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 6/21/2016.
 *
 * @author Bohan Zheng
 */
public class HouseRobberIITest {
  @Test
  public void test() {
    int[] nums = {8, 2, 8, 9, 2};
    assertEquals(17, new HouseRobberII().rob(nums));
  }
}
