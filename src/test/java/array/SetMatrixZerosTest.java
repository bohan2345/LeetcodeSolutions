package array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * <br>
 * Created by Bohan Zheng on 9/2/2015.
 *
 * @author Bohan Zheng
 */
public class SetMatrixZerosTest {
  @Test
  public void test() {
    SetMatrixZeroes test = new SetMatrixZeroes();
    int[][] matrix = {{1, 1, 1, 0}, {1, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 1, 1}};
    int[][] expected = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 0, 0, 0}, {1, 0, 1, 0}};
    test.setZeroes(matrix);
    assertArrayEquals(expected, matrix);
  }
}
