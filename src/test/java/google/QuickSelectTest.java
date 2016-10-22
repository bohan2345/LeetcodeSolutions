package google;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 6/13/2016.
 *
 * @author Bohan Zheng
 */
public class QuickSelectTest {
    @Test
    public void test() {
        QuickSelect test = new QuickSelect();
        int[] nums = {5, 3, 2, 1, 4};
        Assert.assertEquals(3, test.quickSelect(nums, 3));
    }

    @Test
    public void test2() {
        QuickSelect test = new QuickSelect();
        int[] nums = {5, 3, 2, 1, 4};
        Assert.assertEquals(1, test.quickSelect(nums, 1));
    }

    @Test
    public void test3() {
        QuickSelect test = new QuickSelect();
        int[] nums = {5, 3, 2, 1, 4};
        Assert.assertEquals(5, test.quickSelect(nums, 5));
    }
}
