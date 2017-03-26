package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 7/8/16.
 *
 * @author Bohan Zheng
 */
public class BinaryWithNumberTwoTest {
  @Test
  public void test() {
    BinaryWithNumberTwo test = new BinaryWithNumberTwo();
    assertEquals(3, test.totalNumber(4));
  }

  @Test
  public void test2() {
    BinaryWithNumberTwo test = new BinaryWithNumberTwo();
    assertEquals(4, test.totalNumber(8));
  }

  @Test
  public void test3() {
    BinaryWithNumberTwo test = new BinaryWithNumberTwo();
    assertEquals(2, test.totalNumber(5));
  }

  @Test
  public void test4() {
    BinaryWithNumberTwo test = new BinaryWithNumberTwo();
    assertEquals(1, test.totalNumber(7));
  }
}