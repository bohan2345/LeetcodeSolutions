package test.array;

import main.array.RotateArray;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * <p>
 * Created by Bohan Zheng on 10/20/2015.
 *
 * @author Bohan Zheng
 */
public class RotateArrayTest {
    RotateArray test = new RotateArray();

    @Test
    public void test() {
        int[] arrays = new int[]{1, 2, 3, 4, 5, 6, 7};
        test.rotate(arrays, 3);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, arrays);
    }

    @Test
    public void test2() {
        int[] arrays = new int[]{1, 2, 3, 4, 5, 6, 7};
        test.rotate2(arrays, 3);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, arrays);
    }
}
