package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 11/10/2015.
 *
 * @author Bohan Zheng
 */
public class MajorityElementIITest {
    MajorityElementII test = new MajorityElementII();
    @Test
    public void test() {
        int[] nums = {1,2,3,4,4};
        List<Integer> expected = new ArrayList<>(1);
        expected.add(4);
        assertEquals(expected, test.majorityElement(nums));
    }
    @Test
    public void test2() {
        int[] nums = {2,2,2,4,4};
        List<Integer> expected = new ArrayList<>(2);
        expected.add(2);
        expected.add(4);
        assertEquals(expected, test.majorityElement(nums));
    }

    @Test
    public void test3() {
        int[] nums = {1,2,3,4,5};
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, test.majorityElement(nums));
    }
}
