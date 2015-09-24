package test.array;

import main.array.Search2DMatrix;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <br>
 * Created by Bohan Zheng on 9/3/2015.
 *
 * @author Bohan Zheng
 */
public class Search2DMatrixTest {
    @Test
    public void test() {
        Search2DMatrix test = new Search2DMatrix();
        int[][] matrix = {{0, 1, 2, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}};
        assertEquals(false, test.searchMatrix(matrix, 3));
    }

    @Test
    public void test3() {
        Search2DMatrix test = new Search2DMatrix();
        int[][] matrix = {{0, 1, 2, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}};
        assertEquals(true, test.searchMatrix(matrix, 8));
    }

    @Test
    public void test2() {
        Search2DMatrix test = new Search2DMatrix();
        int[][] matrix = {{0, 1, 2, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}};
        assertEquals(true, test.searchMatrix(matrix, 18));
    }

    @Test
    public void test4() {
        Search2DMatrix test = new Search2DMatrix();
        int[][] matrix = {{0, 1, 2, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}};
        assertEquals(true, test.searchMatrix(matrix, 1));
    }

    @Test
    public void test5() {
        Search2DMatrix test = new Search2DMatrix();
        int[][] matrix = {{}, {}};
        assertEquals(false, test.searchMatrix(matrix, 1));
    }

    @Test
    public void test6() {
        Search2DMatrix test = new Search2DMatrix();
        int[][] matrix = {};
        assertEquals(false, test.searchMatrix(matrix, 1));
    }
}
