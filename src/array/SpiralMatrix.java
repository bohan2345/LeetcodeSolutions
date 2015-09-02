package array;

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
        int i = 0, j = 0, direction = 0; // direction 0 -> right, 1 -> down, 2 -> left, 3 -> up
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
                case 0:
                    j++;
                    if (i + j == n - 1) {
                        direction = 1;
                    }
                    break;
                case 1:
                    i++;
                    if (i - j == m - n) {
                        direction = 2;
                    }
                    break;
                case 2:
                    j--;
                    if (i + j == m - 1) {
                        direction = 3;
                    }
                    break;
                case 3:
                    i--;
                    if (i - j == 1) {
                        direction = 0;
                    }
                    break;
            }
            res.add(matrix[i][j]);
        }
        return res;
    }
}
