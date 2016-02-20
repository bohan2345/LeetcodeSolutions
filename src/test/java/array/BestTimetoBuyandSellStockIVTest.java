package array;

import static org.junit.Assert.*;

import org.junit.Test;

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
        assertEquals(7, test.maxProfit(2, prices));
    }

    @Test
    public void test3() {
        BestTimetoBuyandSellStockIV test = new BestTimetoBuyandSellStockIV();
        int[] prices = new int[]{1};
        assertEquals(0, test.maxProfit(10, prices));
    }
}
