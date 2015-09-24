package main.array;

import main.utils.Directions;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.<br>
 * For example,<br>
 * Given n = 3,<br>
 * You should return the following matrix:<br>
 * [<br>
 * &nbsp;[ 1, 2, 3 ],<br>
 * &nbsp;[ 8, 9, 4 ],<br>
 * &nbsp;[ 7, 6, 5 ]<br>
 * ]<br>
 * <p>
 * <br>
 * Created by Bohan Zheng on 9/2/2015.
 *
 * @author Bohan Zheng
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i = 0, j = 0, count = 0;
        Directions direction = Directions.RIGHT;

        while (count < n * n) {
            count++;
            matrix[i][j] = count;
            if (direction == Directions.RIGHT) {
                j++;
                if (i + j == n - 1) {
                    direction = Directions.DOWN;
                }
            } else if (direction == Directions.DOWN) {
                i++;
                if (i == j) {
                    direction = Directions.LEFT;
                }
            } else if (direction == Directions.LEFT) {
                j--;
                if (i + j == n - 1) {
                    direction = Directions.UP;
                }
            } else {
                i--;
                if (i == j + 1) {
                    direction = Directions.RIGHT;
                }
            }
        }
        return matrix;
    }
}
