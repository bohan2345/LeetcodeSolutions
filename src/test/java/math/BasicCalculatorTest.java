package math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 4/26/2016.
 *
 * @author Bohan Zheng
 */
public class BasicCalculatorTest {
  @Test
  public void test() {
    BasicCalculator test = new BasicCalculator();
    assertEquals(1, test.calculate2(" 22 - 21 "));
  }

  @Test
  public void test2() {
    BasicCalculator test = new BasicCalculator();
    assertEquals(1, test.calculate(" (22 - 21) - (-22 + 22) "));
  }

  @Test
  public void test3() {
    BasicCalculator test = new BasicCalculator();
    assertEquals(-4, test.calculate2("1-5"));
  }
}
