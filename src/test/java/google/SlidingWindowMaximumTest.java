package google;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * <p>
 * Created by Bohan Zheng on 6/10/2016.
 *
 * @author Bohan Zheng
 */
public class SlidingWindowMaximumTest {
  @Test
  public void test() {
    SlidingWindowMaximum test = new SlidingWindowMaximum();
    assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, test.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
  }

  @Test
  public void test2() {
    SlidingWindowMaximum test = new SlidingWindowMaximum();
    assertArrayEquals(new int[]{3, 3, 2, 5}, test.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3));
  }
}
