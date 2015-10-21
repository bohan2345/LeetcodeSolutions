package main.array;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <ul>
 * <li>Integers in each row are sorted from left to right.</li>
 * <li>The first integer of each row is greater than the last integer of the previous row.</li>
 * </ul>
 * For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [<br>
 * [1, 3, 5, 7],<br>
 * [10, 11, 16, 20],<br>
 * [23, 30, 34, 50]<br>
 * ]<br>
 * Given target = 3, return true.
 * <p>
 * <br>
 * Created by Bohan Zheng on 9/3/2015.
 *
 * @author Bohan Zheng
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ceil = 0, floor = matrix.length - 1;
        int i = floor;
        while (ceil <= floor) {
            int mid = ceil + (floor - ceil) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] > target) {
                floor = mid - 1;
            } else {
                if (mid + 1 < matrix.length && matrix[mid + 1][0] > target) {
                    i = mid;
                    break;
                }
                ceil = mid + 1;
            }
        }
        return binarySearch(matrix[i], target);
    }

    private boolean binarySearch(int[] arrays, int target) {
        int left = 0, right = arrays.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arrays[mid] == target) {
                return true;
            } else if (arrays[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
