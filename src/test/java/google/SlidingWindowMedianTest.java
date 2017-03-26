package google;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 6/10/2016.
 *
 * @author Bohan Zheng
 */
public class SlidingWindowMedianTest {
  @Test
  public void test() {
    SlidingWindowMedian test = new SlidingWindowMedian();
    int[] nums = {1, 2, 7, 8, 5};
    assertThat(test.medianSlidingWindow(nums, 3), IsIterableContainingInOrder.contains(2, 7, 7));
  }
}
