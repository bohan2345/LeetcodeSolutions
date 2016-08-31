package array;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * <br>
 * Created by Bohan Zheng on 9/8/2015.
 *
 * @author Bohan Zheng
 */
public class SearchinRotatedSortedArrayIITest {
  SearchinRotatedSortedArrayII test = new SearchinRotatedSortedArrayII();

  @Test
  public void test1() {
    int[] array = {1, 1, 1, 1, 1, 1, 1};
    assertTrue(test.search(array, 1));
  }

  @Test
  public void test2() {
    int[] array = {1, 1, 1, 1, 1, 1, 1};
    assertFalse(test.search(array, 2));
  }

  @Test
  public void test3() {
    int[] array = {1, 1, 1, 1, 1, 1, 1, 2, 1, 1};
    assertTrue(test.search(array, 2));
  }

  @Test
  public void test4() {
    int[] array = {1, 2, 3, 3, 3, 4, 0, 0, 1, 1};
    assertTrue(test.search(array, 2));
  }
}
