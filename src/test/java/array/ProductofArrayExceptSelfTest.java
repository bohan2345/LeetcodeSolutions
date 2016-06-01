package array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * <p>
 * Created by Bohan Zheng on 10/22/2015.
 *
 * @author Bohan Zheng
 */
public class ProductofArrayExceptSelfTest {
    ProductofArrayExceptSelf test = new ProductofArrayExceptSelf();

    @Test
    public void test() {
        int[] actual = test.productExceptSelf(new int[]{1, 2, 3, 4});
        assertArrayEquals(new int[]{24, 12, 8, 6}, actual);
    }
}
