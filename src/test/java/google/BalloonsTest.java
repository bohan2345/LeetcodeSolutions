package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 5/16/2016.
 *
 * @author Bohan Zheng
 */
public class BalloonsTest {
  @Test
  public void test() {
    Balloons test = new Balloons();
    int[] nums = {1, 2};
    assertEquals(4, test.maxPoints(nums));
  }

  @Test
  public void test2() {
    Balloons test = new Balloons();
    int[] nums = {3, 1, 5, 8};
    assertEquals(167, test.maxPoints(nums));
  }
}
