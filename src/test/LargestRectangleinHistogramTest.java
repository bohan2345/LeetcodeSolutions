package test;

import array.LargestRectangleinHistogram;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <br>
 * Created by Bohan Zheng on 9/9/2015.
 *
 * @author Bohan Zheng
 */
public class LargestRectangleinHistogramTest {
    LargestRectangleinHistogram test = new LargestRectangleinHistogram();

    @Test
    public void test() {
        int[] height = {2, 1, 5, 6, 2, 3};
        assertEquals(10, test.largestRectangleArea(height));
    }
}
