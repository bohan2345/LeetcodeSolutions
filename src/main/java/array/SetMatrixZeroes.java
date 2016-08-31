package array;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.<br>
 * Follow up:<br>
 * Did you use extra space?<br>
 * A straight forward solution using O(mn) space is probably a bad idea.<br>
 * A simple improvement uses O(m + n) space, but still not the best solution.<br>
 * Could you devise a constant space solution?<br>
 * <br>
 * Created by Bohan Zheng on 9/2/2015.
 *
 * @author Bohan Zheng
 */
public class SetMatrixZeroes {
  public void setZeroes(int[][] matrix) {
    boolean hasZeroTopRow = false, hasZeroLeftColumn = false;
    for (int i = 0; i < matrix.length; i++) {
      hasZeroLeftColumn = hasZeroLeftColumn || matrix[i][0] == 0;
    }
    for (int i = 0; i < matrix[0].length; i++) {
      hasZeroTopRow = hasZeroTopRow || matrix[0][i] == 0;
    }
    if (matrix.length == 1 || matrix[0].length == 1) {
      if (hasZeroLeftColumn) {
        setColumnZero(matrix, 0);
      }
      if (hasZeroTopRow) {
        setRowZero(matrix, 0);
      }
      return;
    }
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        checkZero(matrix, i, j);
      }
    }
    for (int i = 1; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        setRowZero(matrix, i);
      }
    }
    for (int i = 1; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        setColumnZero(matrix, i);
      }
    }
    if (hasZeroLeftColumn) {
      setColumnZero(matrix, 0);
    }
    if (hasZeroTopRow) {
      setRowZero(matrix, 0);
    }
  }

  private void checkZero(int[][] matrix, int i, int j) {
    if (matrix[i][j] != 0) {
      return;
    }
    matrix[i][0] = 0;
    matrix[0][j] = 0;
  }

  private void setRowZero(int[][] matrix, int row) {
    for (int i = 0; i < matrix[row].length; i++) {
      matrix[row][i] = 0;
    }
  }

  private void setColumnZero(int[][] matrix, int col) {
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][col] = 0;
    }
  }
}
