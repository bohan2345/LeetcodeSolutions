package array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 2/17/2016.
 *
 * @author Bohan Zheng
 */
public class BestTimetoBuyandSellStockIVTest {
  @Test
  public void test() {
    BestTimetoBuyandSellStockIV test = new BestTimetoBuyandSellStockIV();
    int[] prices = new int[]{1, 5};
    assertEquals(4, test.maxProfit(1, prices));
  }

  @Test
  public void test2() {
    BestTimetoBuyandSellStockIV test = new BestTimetoBuyandSellStockIV();
    int[] prices = new int[]{6, 1, 3, 2, 4, 7};
    assertEquals(7, test.maxProfit2(2, prices));
  }

  @Test
  public void test3() {
    BestTimetoBuyandSellStockIV test = new BestTimetoBuyandSellStockIV();
    int[] prices = new int[]{1};
    assertEquals(0, test.maxProfit(10, prices));
  }

  @Test
  public void test4() {
    BestTimetoBuyandSellStockIV test = new BestTimetoBuyandSellStockIV();
    int[] prices = new int[]{0, 1000, 1000, 1000, 1000, 1000, 1000, 1000};
    assertEquals(1000, test.maxProfit2(3, prices));
  }
}
