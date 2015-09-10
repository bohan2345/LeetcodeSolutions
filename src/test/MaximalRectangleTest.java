package test;

import array.MaximalRectangle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <br>
 * Created by Bohan Zheng on 9/9/2015.
 *
 * @author Bohan Zheng
 */
public class MaximalRectangleTest {
    MaximalRectangle test = new MaximalRectangle();

    @Test
    public void test() {
        char[][] matrix = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        assertEquals(6, test.maximalRectangle(matrix));
    }
}
