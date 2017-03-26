package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 7/2/16.
 *
 * @author Bohan Zheng
 */
public class ItoaTest {
  @Test
  public void test() {
    Itoa test = new Itoa();
    assertEquals(Integer.toBinaryString(123), test.itoa(123, 2));
  }

  @Test
  public void test2() {
    Itoa test = new Itoa();
    assertEquals(Integer.toOctalString(123), test.itoa(123, 8));
  }

  @Test
  public void test3() {
    Itoa test = new Itoa();
    assertEquals(Integer.toHexString(123).toUpperCase(), test.itoa(123, 16));
  }
}