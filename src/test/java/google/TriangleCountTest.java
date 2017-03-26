package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 6/13/2016.
 *
 * @author Bohan Zheng
 */
public class
TriangleCountTest {
  @Test
  public void test() {
    TriangleCount test = new TriangleCount();
    int[] nums = {1, 2, 3, 4, 5};
    assertEquals(3, test.count(nums));
  }
}
