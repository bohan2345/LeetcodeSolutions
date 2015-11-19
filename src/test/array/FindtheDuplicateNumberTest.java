package test.array;

import main.array.FindtheDuplicateNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 11/19/2015.
 *
 * @author Bohan Zheng
 */
public class FindtheDuplicateNumberTest {
    FindtheDuplicateNumber test = new FindtheDuplicateNumber();

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 5};
        assertEquals(5, test.findDuplicate(nums));
    }

    @Test
    public void test2() {
        int[] nums = {5, 2, 4, 3, 5, 1};
        assertEquals(5, test.findDuplicate(nums));
    }
}
