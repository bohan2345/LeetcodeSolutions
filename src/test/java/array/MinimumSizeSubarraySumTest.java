package array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 10/27/2015.
 *
 * @author Bohan Zheng
 */
public class MinimumSizeSubarraySumTest {
  MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();

  @Test
  public void test() {
    int actural = test.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    assertEquals(2, actural);
  }

  @Test
  public void test2() {
    int actural = test.minSubArrayLen(3, new int[]{1, 1});
    assertEquals(0, actural);
  }

  @Test
  public void test3() {
    int actural = test.minSubArrayLen(3, new int[]{1, 4, 4});
    assertEquals(1, actural);
  }
}
