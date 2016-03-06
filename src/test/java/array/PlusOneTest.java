package array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * <br>
 * Created by Bohan Zheng on 9/2/2015.
 *
 * @author Bohan Zheng
 */
public class PlusOneTest {
    @Test
    public void test() {
        PlusOne test = new PlusOne();
        int[] digits = {9, 9, 9};
        int[] expected = {1, 0, 0, 0};
        assertArrayEquals(expected, test.plusOne(digits));
    }
}
