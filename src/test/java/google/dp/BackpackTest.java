package google.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 6/23/2016.
 *
 * @author Bohan Zheng
 */
public class BackpackTest {
    @Test
    public void test() {
        Backpack test = new Backpack();
        int[] A = {2, 3, 4, 5};
        assertEquals(10, test.backPack(10, A));
    }
}
