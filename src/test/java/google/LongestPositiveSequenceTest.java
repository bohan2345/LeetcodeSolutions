package google;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 7/2/16.
 *
 * @author Bohan Zheng
 */
public class LongestPositiveSequenceTest {
  @Test
  public void test() {
    LongestPositiveSequence test = new LongestPositiveSequence();
    assertThat(test.findLongest(new int[]{-1, 2, 3, -4, 6, 12, 8, 9, -3,
        -5}), IsIterableContainingInOrder.contains(6, 12, 8, 9));
  }
}