package array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 12/15/2015.
 *
 * @author Bohan Zheng
 */
public class BestTimetoBuyandSellStockIITest {
    @Test
    public void test() {
        BestTimetoBuyandSellStockII test = new BestTimetoBuyandSellStockII();
        assertEquals(0, test.maxProfit(new int[]{1}));
    }

    @Test
    public void test2() {
        BestTimetoBuyandSellStockII test = new BestTimetoBuyandSellStockII();
        assertEquals(1, test.maxProfit(new int[]{1, 2}));
    }
}
