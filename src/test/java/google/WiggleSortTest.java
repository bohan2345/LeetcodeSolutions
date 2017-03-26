package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 6/9/2016.
 *
 * @author Bohan Zheng
 */
public class WiggleSortTest {
  @Test
  public void test() {
    int[] nums = {6, 3, 5, 4, 2, 1};
    new WiggleSort().wiggleSort(nums);
    assertTrue(nums[0] <= nums[1]);
    for (int i = 1; i < nums.length - 1; i++) {
      if (i % 2 == 0)
        assertTrue(nums[i] <= nums[i - 1] && nums[i] <= nums[i + 1]);
      else
        assertTrue(nums[i] >= nums[i - 1] && nums[i] >= nums[i + 1]);
    }
  }

  @Test
  public void test2() {
    int[] nums = {1, 1, 1, 2, 2, 2};
    new WiggleSort().wiggleSort(nums);
    assertTrue(nums[0] <= nums[1]);
    for (int i = 1; i < nums.length - 1; i++) {
      if (i % 2 == 0)
        assertTrue(nums[i] <= nums[i - 1] && nums[i] <= nums[i + 1]);
      else
        assertTrue(nums[i] >= nums[i - 1] && nums[i] >= nums[i + 1]);
    }
  }

  @Test
  public void test3() {
    int[] nums = {6, 2, 3, 4, 5, 1};
    WiggleSort test = new WiggleSort();
    assertEquals(3, test.findMedium(nums));
  }

  @Test
  public void test4() {
    int[] nums = {1, 1, 1, 2, 2, 2};
    WiggleSort test = new WiggleSort();
    assertEquals(1, test.findTopK(nums, 0, nums.length - 1, 3));
  }
}
