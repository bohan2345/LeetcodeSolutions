package google.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 6/25/16.
 *
 * @author Bohan Zheng
 */
public class MinAdjustmentCostTest {
    @Test
    public void test() {
        List<Integer> A = Arrays.asList(11, 11, 3, 5, 11, 16, 12, 11, 15, 11, 16, 16, 16, 16, 16, 11, 16);
        ArrayList<Integer> AA = new ArrayList<>(A);
        MinimumAdjustmentCost test = new MinimumAdjustmentCost();
        assertEquals(53, test.MinAdjustmentCost(AA, 0));
    }

    @Test
    public void test2() {
        List<Integer> A = Arrays.asList(1, 3, 5, 7, 6, 4, 2, 4, 6, 8, 10, 11, 9, 8, 6, 8, 10, 12, 14);
        ArrayList<Integer> AA = new ArrayList<>(A);
        MinimumAdjustmentCost test = new MinimumAdjustmentCost();
        assertEquals(0, test.MinAdjustmentCost(AA, 2));
    }
}