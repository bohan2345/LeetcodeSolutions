package array;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
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
        test.rotate3(arrays, 3);
        assertThat(arrays).isEqualTo(new int[]{5, 6, 7, 1, 2, 3, 4});
    }

    @Test
    public void test2() {
        int[] arrays = new int[]{1, 2, 3, 4, 5, 6, 7};
        test.rotate2(arrays, 3);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, arrays);
    }

    @Test
    public void test3() {
        int[] arrays = new int[]{1, 2, 3};
        test.rotate3(arrays, 1);
        assertThat(arrays).isEqualTo(new int[]{3, 1, 2});
    }

    @Test
    public void test4() {
        int[] arrays = new int[]{1};
        test.rotate3(arrays, 1);
        assertThat(arrays).isEqualTo(new int[]{1});
    }
}
