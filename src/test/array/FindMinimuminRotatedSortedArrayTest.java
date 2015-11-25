package test.array;

import main.array.FindMinimuminRotatedSortedArray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 11/24/2015.
 *
 * @author Bohan Zheng
 */
public class FindMinimuminRotatedSortedArrayTest {
    FindMinimuminRotatedSortedArray test = new FindMinimuminRotatedSortedArray();

    @Test
    public void test() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        assertEquals(0, test.findMin(nums));
    }

    @Test
    public void test1() {
        int[] nums = {4, 5, 6, 7};
        assertEquals(4, test.findMin(nums));
    }

    @Test
    public void test2() {
        int[] nums = {0};
        assertEquals(0, test.findMin(nums));
    }
}
