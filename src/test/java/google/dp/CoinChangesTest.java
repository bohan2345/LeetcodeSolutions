package google.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 6/22/2016.
 *
 * @author Bohan Zheng
 */
public class CoinChangesTest {
    @Test
    public void test() {
        CoinChange test = new CoinChange();
        int[] coins = {1, 2, 5};
        Assert.assertEquals(3, test.coinChange(coins, 11));
    }
}
