package test.array;

import main.array.MergeSortedArray;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * <br>
 * Created by Bohan Zheng on 9/22/2015.
 *
 * @author Bohan Zheng
 */
public class MergeSortedArrayTest {
    MergeSortedArray test = new MergeSortedArray();

    @Test
    public void test() {
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums1 = {1, 2, 4, 7, 8, 0, 0, 0};
        int[] nums2 = {3, 5, 6};
        test.merge(nums1, 5, nums2, 3);
        assertArrayEquals(expected, nums1);
    }

    @Test
    public void test2() {
        int[] expected = {1, 2, 3};
        int[] nums1 = {0, 0, 0};
        int[] nums2 = {1, 2, 3};
        test.merge(nums1, 0, nums2, 3);
        assertArrayEquals(expected, nums1);
    }

    @Test
    public void test3() {
        int[] expected = {1, 2, 3};
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {0, 0, 0};
        test.merge(nums1, 3, nums2, 0);
        assertArrayEquals(expected, nums1);
    }
}
