package array;

import array.SortColor;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * <br>
 * Created by Bohan Zheng on 9/3/2015.
 *
 * @author Bohan Zheng
 */
public class SortColorTest {
    SortColor test = new SortColor();

    @Test
    public void test() {
        int[] colors = {0, 1, 0, 2, 0, 1, 0, 2};
        int[] expected = {0, 0, 0, 0, 1, 1, 2, 2};
        test.sortColors(colors);
        assertArrayEquals(expected, colors);
    }

    @Test
    public void test22() {
        int[] colors = {0, 1, 0, 2, 0, 1, 0, 2};
        int[] expected = {0, 0, 0, 0, 1, 1, 2, 2};
        test.sortColors(colors);
        assertArrayEquals(expected, colors);
    }

    @Test
    public void test2() {
        int[] colors = {0, 0, 0, 0, 1, 2};
        int[] expected = {0, 0, 0, 0, 1, 2};
        test.sortColors(colors);
        assertArrayEquals(expected, colors);
    }

    @Test
    public void test3() {
        int[] colors = {1, 0};
        int[] expected = {0, 1};
        test.sortColors(colors);
        assertArrayEquals(expected, colors);
    }

    @Test
    public void test4() {
        int[] colors =   {1, 2, 1, 0, 2, 1, 1, 1, 2, 0, 0, 0, 1, 1, 1, 1, 0, 2, 0, 0, 1, 0, 2, 0, 0, 1, 2, 1, 0};
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2};
        test.sortColors(colors);
        assertArrayEquals(expected, colors);
    }
}
