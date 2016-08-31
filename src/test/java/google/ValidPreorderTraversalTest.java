package google;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 6/1/2016.
 *
 * @author Bohan Zheng
 */
public class ValidPreorderTraversalTest {
  @Test
  public void test() {
    ValidPreorderTraversal test = new ValidPreorderTraversal();
    assertTrue(test.isValid("1##"));
  }

  @Test
  public void test2() {
    ValidPreorderTraversal test = new ValidPreorderTraversal();
    assertTrue(test.isValid("124###3##"));
  }

  @Test
  public void test3() {
    ValidPreorderTraversal test = new ValidPreorderTraversal();
    assertFalse(test.isValid("124##3##"));
  }
}
