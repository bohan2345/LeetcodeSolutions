package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 7/10/16.
 *
 * @author Bohan Zheng
 */
public class MoveArrayElementTest {
  @Test
  public void test() {
    MoveArrayElement test = new MoveArrayElement();
    int[] array = {1, 2, 3, 0};
    assertEquals(4, test.moveBack(array));
  }

  @Test
  public void test2() {
    MoveArrayElement test = new MoveArrayElement();
    int[] array = {0, 1, 2, 3};
    assertEquals(1, test.moveBack(array));
  }

  @Test
  public void test3() {
    MoveArrayElement test = new MoveArrayElement();
    int[] array = {1, 0, 3, 4, 2};
    assertEquals(6, test.moveBack(array));
  }
}