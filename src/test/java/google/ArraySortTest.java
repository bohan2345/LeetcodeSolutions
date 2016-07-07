package google;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * <p>
 * Created by Bohan Zheng on 7/6/2016.
 *
 * @author Bohan Zheng
 */
public class ArraySortTest {
    @Test
    public void test() {
        int[] nums = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        ArraySort test = new ArraySort();
        test.mergeSort(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void test2() {
        int[] nums = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        ArraySort test = new ArraySort();
        test.quickSort(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void test3() {
        int[] nums = {4, 5, 1, 3, 2};
        int[] expected = {1, 2, 3, 4, 5};
        ArraySort test = new ArraySort();
        test.quickSort(nums);
        assertArrayEquals(expected, nums);
    }
}
