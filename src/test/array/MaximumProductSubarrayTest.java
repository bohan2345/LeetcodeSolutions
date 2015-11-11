package test.array;

import main.array.MaximumProductSubarray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 11/9/2015.
 *
 * @author Bohan Zheng
 */
public class MaximumProductSubarrayTest {
    MaximumProductSubarray test = new MaximumProductSubarray();

    @Test
    public void test() {
        assertEquals(6, test.maxProduct(new int[]{2, 3, -2, 4}));
    }
}
