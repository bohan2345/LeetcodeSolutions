package test.array;

import main.array.RemoveDuplicatesfromSortedArrayII;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * <br>
 * Created by Bohan Zheng on 9/4/2015.
 *
 * @author Bohan Zheng
 */
public class RemoveDuplicatesfromSortedArrayIITest {
    RemoveDuplicatesfromSortedArrayII test = new RemoveDuplicatesfromSortedArrayII();

    @Test
    public void test() {
        int[] nums = {2, 2, 2, 2};
        int[] expected = {2, 2};
        int i = test.removeDuplicates(nums);
        assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, i));
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 2, 2};
        int[] expected = {1, 2, 2};
        int i = test.removeDuplicates(nums);
        assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, i));
    }
}
