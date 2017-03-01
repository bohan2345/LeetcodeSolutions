package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * <br>
 * Created by Bohan Zheng on 9/1/2015.
 *
 * @author Bohan Zheng
 */
public class SprialMatrixTest {
  @Test
  public void spiralOrderTest() {
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    SpiralMatrix test = new SpiralMatrix();
    List<Integer> expected = new ArrayList<>();
    expected.add(1);
    expected.add(2);
    expected.add(3);
    expected.add(6);
    expected.add(9);
    expected.add(8);
    expected.add(7);
    expected.add(4);
    expected.add(5);
    assertEquals(expected, test.spiralOrder(matrix));
  }

  @Test
  public void spiralOrderTest2() {
    int[][] matrix = {{3, 2}};
    SpiralMatrix test = new SpiralMatrix();
    List<Integer> expected = new ArrayList<>();
    expected.add(3);
    expected.add(2);
    assertEquals(expected, test.spiralOrder(matrix));
  }

  @Test
  public void spiralOrderTest3() {
    int[][] matrix = {};
    SpiralMatrix test = new SpiralMatrix();
    List<Integer> expected = new ArrayList<>();
    assertEquals(expected, test.spiralOrder(matrix));
  }

  @Test
  public void spiralOrderTest4() {
    int[][] matrix = {{3}, {2}};
    SpiralMatrix test = new SpiralMatrix();
    List<Integer> expected = new ArrayList<>();
    expected.add(3);
    expected.add(2);
    assertEquals(expected, test.spiralOrder(matrix));
  }
}
