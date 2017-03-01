package google;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 7/6/16.
 *
 * @author Bohan Zheng
 */
public class FirstDuplicateNumberTest {
  @Test
  public void test() {
    FirstDuplicateNumber test = new FirstDuplicateNumber();
    int[] nums = {1, 2, 3, 4, 3, 2, 1};
    Assert.assertEquals(1, test.firstDuplicate(nums));
  }

  @Test
  public void test2() {
    FirstDuplicateNumber test = new FirstDuplicateNumber();
    int[] nums = {1, 1, 2, 2, 3, 3};
    Assert.assertEquals(1, test.firstDuplicate(nums));
  }
}
