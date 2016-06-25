package google.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 6/21/2016.
 *
 * @author Bohan Zheng
 */
public class MaximalSquareTest {
    @Test
    public void test() {
        char[][] matrix = {{'1', '1'}, {'1', '1'}};
        assertEquals(4, new MaximalSquare().maximalSquare(matrix));
    }

    @Test
    public void test2() {
        char[][] matrix = {{'0', '0'}, {'0', '0'}};
        assertEquals(0, new MaximalSquare().maximalSquare(matrix));
    }
}
