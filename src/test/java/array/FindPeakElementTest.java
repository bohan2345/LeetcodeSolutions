package array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 11/24/2015.
 *
 * @author Bohan Zheng
 */
public class FindPeakElementTest {
  FindPeakElement test = new FindPeakElement();

  @Test
  public void test() {
    int[] nums = {1, 2, 3, 1};
    assertEquals(2, test.findPeakElement(nums));
  }

  @Test
  public void test2() {
    int[] nums = {1, 2, 3, 4};
    assertEquals(3, test.findPeakElement(nums));
  }

  @Test
  public void test3() {
    int[] nums = {4, 3, 2, 1};
    assertEquals(0, test.findPeakElement(nums));
  }

  @Test
  public void test4() {
    int[] nums = {1};
    assertEquals(0, test.findPeakElement(nums));
  }
}
