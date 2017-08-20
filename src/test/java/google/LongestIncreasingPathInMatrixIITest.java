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
public class LongestIncreasingPathInMatrixIITest {
    @Test
    public void test() {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 2, 1}};
        assertThat(new LongestIncreasingPathInMatrixII().findLongest(matrix), IsIterableContainingInOrder.contains(1, 2, 6, 9));
    }

    @Test
    public void test2() {
        int[][] matrix = {{7, 8, 9}, {9, 7, 6}, {7, 2, 3}};
        assertThat(new LongestIncreasingPathInMatrixII().findLongest(matrix), IsIterableContainingInOrder.contains(2, 3, 6, 7, 8, 9));
    }
}
