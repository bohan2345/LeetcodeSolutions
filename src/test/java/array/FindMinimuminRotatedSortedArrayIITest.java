package array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 11/24/2015.
 *
 * @author Bohan Zheng
 */
public class FindMinimuminRotatedSortedArrayIITest {
  FindMinimuminRotatedSortedArrayII test = new FindMinimuminRotatedSortedArrayII();

  @Test
  public void test() {
    int[] nums = {3, 1, 1};
    assertEquals(1, test.findMin(nums));
  }

  @Test
  public void test2() {
    int[] nums = {1, 1, 1};
    assertEquals(1, test.findMin(nums));
  }

  @Test
  public void test3() {
    int[] nums = {1};
    assertEquals(1, test.findMin(nums));
  }

  @Test
  public void test4() {
    int[] nums = {3, 1, 3};
    assertEquals(1, test.findMin(nums));
  }
}
