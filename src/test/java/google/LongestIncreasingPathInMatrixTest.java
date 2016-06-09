package google;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 6/8/2016.
 *
 * @author Bohan Zheng
 */
public class LongestIncreasingPathInMatrixTest {
    @Test
    public void test() {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 2, 1}};
        assertThat(new LongestIncreasingPathInMatrix().findLongest(matrix), IsIterableContainingInOrder.contains(1, 2, 6, 9));
    }
}
