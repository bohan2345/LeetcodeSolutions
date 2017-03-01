package array;

import utils.Directions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * For example, Given the following matrix:
 * <p>
 * [<br>
 * &nbsp;[ 1, 2, 3 ],<br>
 * &nbsp;[ 4, 5, 6 ],<br>
 * &nbsp;[ 7, 8, 9 ]<br>
 * ]<br>
 * You should return [1,2,3,6,9,8,7,4,5].
 * <br>
 * Created by Bohan Zheng on 9/1/2015.
 *
 * @author Bohan Zheng
 */
public class SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return res;
    }
    int i = 0, j = 0; // direction 0 -> right, 1 -> down, 2 -> left, 3 -> up
    Directions direction = Directions.RIGHT;
    int m = matrix.length, n = matrix[0].length, total = m * n;
    if (n == 1) {
      for (; i < m; i++) {
        res.add(matrix[i][j]);
      }
      return res;
    }
    res.add(matrix[i][j]);
    while (i < m && j < n && res.size() < total) {
      switch (direction) {
        case RIGHT:
          j++;
          if (i + j == n - 1) {
            direction = Directions.DOWN;
          }
          break;
        case DOWN:
          i++;
          if (i - j == m - n) {
            direction = Directions.LEFT;
          }
          break;
        case LEFT:
          j--;
          if (i + j == m - 1) {
            direction = Directions.UP;
          }
          break;
        case UP:
          i--;
          if (i - j == 1) {
            direction = Directions.RIGHT;
          }
          break;
      }
      res.add(matrix[i][j]);
    }
    return res;
  }
}
