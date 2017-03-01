package array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 12/15/2015.
 *
 * @author Bohan Zheng
 */
public class BestTimetoBuyandSellStockIIITest {
  @Test
  public void test() {
    BestTimetoBuyandSellStockIII test = new BestTimetoBuyandSellStockIII();
    assertEquals(2, test.maxProfit(new int[]{2, 1, 2, 0, 1}));
  }

  @Test
  public void test2() {
    BestTimetoBuyandSellStockIII test = new BestTimetoBuyandSellStockIII();
    assertEquals(4, test.maxProfit(new int[]{1, 2, 1, 4}));
  }

  @Test
  public void test3() {
    BestTimetoBuyandSellStockIII test = new BestTimetoBuyandSellStockIII();
    assertEquals(1, test.maxProfit(new int[]{1, 2}));
  }
}
