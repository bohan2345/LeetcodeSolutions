package array;

import array.PascalsTriangleII;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 10/27/2015.
 *
 * @author Bohan Zheng
 */
public class PascalsTriangleIITest {
    PascalsTriangleII test = new PascalsTriangleII();

    @Test
    public void test() {
        assertThat(test.getRow(4), IsIterableContainingInOrder.contains(1, 4, 6, 4, 1));
    }
}
