package google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        assertEquals(4, new LongestIncreasingPathInMatrix().findLongest(matrix));
    }

    @Test
    public void test2() {
        int[][] matrix = {{7, 8, 9}, {9, 7, 6}, {7, 2, 3}};
        assertEquals(6, new LongestIncreasingPathInMatrix().findLongest(matrix));
    }
}
