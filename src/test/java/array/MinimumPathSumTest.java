package array;

import array.MinimumPathSum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <br>
 * Created by Bohan Zheng on 9/2/2015.
 *
 * @author Bohan Zheng
 */
public class MinimumPathSumTest {
    @Test
    public void test() {
        MinimumPathSum test = new MinimumPathSum();
        int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        assertEquals(5, test.minPathSum(grid));
    }
}
