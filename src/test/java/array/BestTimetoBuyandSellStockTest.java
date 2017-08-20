package array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 12/15/2015.
 *
 * @author Bohan Zheng
 */
public class BestTimetoBuyandSellStockTest {
    @Test
    public void test() {
        BestTimetoBuyandSellStock test = new BestTimetoBuyandSellStock();
        assertEquals(0, test.maxProfit(new int[]{1}));
    }

    @Test
    public void test2() {
        BestTimetoBuyandSellStock test = new BestTimetoBuyandSellStock();
        assertEquals(1, test.maxProfit(new int[]{1, 2}));
    }
}
