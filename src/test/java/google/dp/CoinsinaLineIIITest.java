package google.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 6/22/2016.
 *
 * @author Bohan Zheng
 */
public class CoinsinaLineIIITest {
  @Test
  public void test() {
    int[] coins = {1, 2, 3};
    CoinsinaLineIII test = new CoinsinaLineIII();
    assertEquals(4, test.maxMoneygoFirst(coins));
  }

  @Test
  public void test2() {
    int[] coins = {1, 3};
    CoinsinaLineIII test = new CoinsinaLineIII();
    assertEquals(3, test.maxMoneygoFirst(coins));
  }

  @Test
  public void test3() {
    int[] coins = {3, 2, 2, 3, 1, 2};
    CoinsinaLineIII test = new CoinsinaLineIII();
    assertEquals(8, test.maxMoneygoFirst(coins));
  }
}
