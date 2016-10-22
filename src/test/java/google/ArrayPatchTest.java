package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 5/17/2016.
 *
 * @author Bohan Zheng
 */
public class ArrayPatchTest {
    @Test
    public void test() {
        ArrayPatch test = new ArrayPatch();
        int[] nums = {1, 3};
        assertEquals(1, test.numOfPatches(nums, 6));
    }

    @Test
    public void test2() {
        ArrayPatch test = new ArrayPatch();
        int[] nums = {1, 5, 10};
        assertEquals(2, test.numOfPatches(nums, 20));
    }
}
