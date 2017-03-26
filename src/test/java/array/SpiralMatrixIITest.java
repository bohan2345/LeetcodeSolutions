package array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * <br>
 * Created by Bohan Zheng on 9/2/2015.
 *
 * @author Bohan Zheng
 */
public class SpiralMatrixIITest {
  @Test
  public void test() {
    SpiralMatrixII test = new SpiralMatrixII();
    int[][] expected = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
    assertArrayEquals(expected, test.generateMatrix(3));
  }

  @Test
  public void test2() {
    SpiralMatrixII test = new SpiralMatrixII();
    int[][] expected = {{1}};
    assertArrayEquals(expected, test.generateMatrix(1));
  }

  @Test
  public void test3() {
    SpiralMatrixII test = new SpiralMatrixII();
    int[][] expected = {};
    assertArrayEquals(expected, test.generateMatrix(0));
  }
}
