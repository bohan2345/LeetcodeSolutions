package google;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * <p>
 * Created by Bohan Zheng on 6/1/2016.
 *
 * @author Bohan Zheng
 */
public class CountSmallerNumberAfterSelfTest {
  @Test
  public void test() {
    CountSmallerNumberAfterSelf test = new CountSmallerNumberAfterSelf();
    int[] nums = {5, 2, 6, 1};
    int[] expected = {2, 1, 1, 0};
    assertArrayEquals(expected, test.count(nums));
  }
}
