package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 6/9/2016.
 *
 * @author Bohan Zheng
 */
public class WiggleSortTest {
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        new WiggleSort().wiggleSort(nums);
        assertTrue(nums[0] <= nums[1]);
        for (int i = 1; i < nums.length - 1; i++) {
            if (i % 2 == 0)
                assertTrue(nums[i] <= nums[i - 1] && nums[i] <= nums[i + 1]);
            else
                assertTrue(nums[i] >= nums[i - 1] && nums[i] >= nums[i + 1]);
        }
    }
}
