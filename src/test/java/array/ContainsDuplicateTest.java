package array;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 11/27/2015.
 *
 * @author Bohan Zheng
 */
public class ContainsDuplicateTest {
  ContainsDuplicateI test = new ContainsDuplicateI();

  @Test
  public void test() {
    assertTrue(test.containsDuplicate(new int[]{1, 1}));
  }
}
