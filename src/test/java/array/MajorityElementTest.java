package array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 11/10/2015.
 *
 * @author Bohan Zheng
 */
public class MajorityElementTest {
  MajorityElement test = new MajorityElement();

  @Test
  public void test() {
    assertEquals(test.majorityElement(new int[]{1, 1, 1, 1, 3, 3, 2}), 1);
  }

  @Test
  public void test2() {
    assertEquals(test.majorityElement2(new int[]{1, 1, 1, 1, 3, 3, 2}), 1);
  }
}
