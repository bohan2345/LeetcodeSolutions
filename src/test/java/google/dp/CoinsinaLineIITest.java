package google.dp;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 6/22/2016.
 *
 * @author Bohan Zheng
 */
public class CoinsinaLineIITest {
    @Test
    public void test() {
        CoinsinaLineII test = new CoinsinaLineII();
        int[] values = {1, 2, 2};
        assertTrue(test.firstWillWin(values));
    }

    @Test
    public void test2() {
        CoinsinaLineII test = new CoinsinaLineII();
        int[] values = {1, 2, 4};
        assertFalse(test.firstWillWin(values));
    }
}
