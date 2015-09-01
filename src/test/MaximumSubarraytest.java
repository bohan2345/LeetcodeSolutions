package test;

import array.MaximumSubarray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <br>
 * Created by Bohan Zheng on 9/1/2015.
 *
 * @author Bohan Zheng
 */
public class MaximumSubarraytest {
    @Test
    public void testMaxSubArray() {
        MaximumSubarray test = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, test.maxSubArray(nums));
        int[] nums2 = {-1};
        assertEquals(-1, test.maxSubArray(nums2));
    }
}
