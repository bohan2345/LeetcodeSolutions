package test.array;

import main.array.RotateImage;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Bohan Zheng on 8/31/2015.
 */
public class RotateImageTest {
    @Test
    public void rotateTest() {
        RotateImage test = new RotateImage();
        int[][] matrix = {{0, 1, 2, 3, 4}, {10, 11, 12, 13, 14}, {20, 21, 22, 23, 24}, {30, 31, 32, 33, 34}, {40, 41, 42, 43, 44}};
        test.rotate(matrix);
        int[][] expect = {{40, 30, 20, 10, 0}, {41, 31, 21, 11, 1}, {42, 32, 22, 12, 2}, {43, 33, 23, 13, 3}, {44, 34, 24, 14, 4}};
        assertArrayEquals(matrix, expect);
    }
}
