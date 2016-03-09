package array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <br>
 * Created by Bohan Zheng on 9/1/2015.
 *
 * @author Bohan Zheng
 */
public class MaximumSubarraytest {
    MaximumSubarray test = new MaximumSubarray();

    @Test
    public void testMaxSubArray() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, test.maxSubArray(nums));
        int[] nums2 = {-1};
        assertEquals(-1, test.maxSubArray(nums2));
    }

    @Test
    public void test2() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, test.maxSubArray2(nums));
    }

    @Test
    public void test3() {
        int[] nums = {-2, 1};
        assertEquals(1, test.maxSubArray2(nums));
    }

    @Test
    public void test4() {
        int[] nums = {-2};
        assertEquals(-2, test.maxSubArray2(nums));
    }

    @Test
    public void test5() {
        int[] nums = {8, -19, 5, -4, 20};
        assertEquals(21, test.maxSubArray2(nums));
    }
}
