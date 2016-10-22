package array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * <p>
 * Created by Bohan Zheng on 10/27/2015.
 *
 * @author Bohan Zheng
 */
public class MoveZeroesTest {
    MoveZeroes test = new MoveZeroes();

    @Test
    public void test() {
        int[] arrays = new int[]{0, 1, 0, 3, 12};
        test.moveZeroes(arrays);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, arrays);
    }
}
