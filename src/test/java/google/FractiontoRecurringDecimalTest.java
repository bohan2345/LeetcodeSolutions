package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 5/12/2016.
 *
 * @author Bohan Zheng
 */
public class FractiontoRecurringDecimalTest {
  @Test
  public void test() {
    math.FractiontoRecurringDecimal test = new math.FractiontoRecurringDecimal();
    assertEquals("0.(6)", test.fractionToDecimal(2, 3));
  }

  @Test
  public void test2() {
    math.FractiontoRecurringDecimal test = new math.FractiontoRecurringDecimal();
    assertEquals("0", test.fractionToDecimal(0, 3));
  }
}
