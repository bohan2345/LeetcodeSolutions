package google.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 6/25/16.
 *
 * @author Bohan Zheng
 */
public class MaximumSubarrayIIITest {
  @Test
  public void test() {
    int[] nums = {-1, 4, -2, 3, -2, 3};
    assertEquals(8, new MaximumSubarrayIII().maxSubArray(nums, 2));
  }

  @Test
  public void test2() {
    int[] nums = {-1, -2, -3, -100, -1, -50};
    assertEquals(-2, new MaximumSubarrayIII().maxSubArray(nums, 2));
  }

  @Test
  public void test3() {
    int[] nums = {-1, 0, 1};
    assertEquals(0, new MaximumSubarrayIII().maxSubArray(nums, 3));
  }
}