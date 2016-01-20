package array;

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

    @Test
    public void test2() {
        int[] height = {1};
        assertEquals(1, test.largestRectangleArea(height));
    }

    @Test
    public void test3() {
        int[] height = {2, 1, 2};
        assertEquals(3, test.largestRectangleArea(height));
    }

    @Test
    public void test4() {
        int[] height = {0, 9};
        assertEquals(9, test.largestRectangleArea(height));
    }

    @Test
    public void test5() {
        int[] height = {5, 4, 1, 2};
        assertEquals(8, test.largestRectangleArea(height));
    }

    @Test
    public void test6() {
        int[] height = {4, 2, 0, 3, 2, 5};
        assertEquals(6, test.largestRectangleArea(height));
    }
}
